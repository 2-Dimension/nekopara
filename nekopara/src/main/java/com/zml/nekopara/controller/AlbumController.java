package com.zml.nekopara.controller;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.user5u.myweb.domain.Album;
import com.user5u.myweb.domain.AlbumQueryObject;
import com.user5u.myweb.service.IAlbumService;
import com.user5u.myweb.util.PageResult;
import com.user5u.myweb.util.QiNiuImageUploadUtil;

@Controller
public class AlbumController {

	@Autowired
	private IAlbumService albumService;
	
	/**
	 * =============================后台==================================
	 */
	
	/**
	 * 编辑页面
	 * @return
	 */
	@RequestMapping("/admin/albumEditPage")
	public String albumEditPage(Long id,String cmd,Model model){
		//更新
		if(id!=null){
			if("edit".equals(cmd)){
				Album album= albumService.get(id);
				model.addAttribute("album",album);
			}
		}
		
		model.addAttribute("cmd",cmd);
		return "/admin/albumEdit";
	}
	
	/**
	 * 保存或者更新
	 * @param article
	 * @param cmd
	 * @return
	 */
	@RequestMapping("/admin/albumEdit")
	public String albumEdit(Album album,String cmd,MultipartFile file){
		//编辑
		if("edit".equals(cmd)){
			//如果没有上传图片就不修改原来的图片
			Album oldAlbum = albumService.get(album.getId());
			if(file.isEmpty()){
				album.setImage(oldAlbum.getImage());
				//修改时上传了新的 图片
			}else{
					//因为图片文件在七牛云上,可以被其他的系统引用,所以不删除原来的文件
					//上传新文件
					String uuidStr = UUID.randomUUID().toString().replace("-", "");
					String filename = "upload/"+uuidStr+"."+file.getContentType().substring(file.getContentType().indexOf("/")+1);
					try {
						//将文件上传到七牛云
						new QiNiuImageUploadUtil().upload(file.getBytes(),filename);
					} catch (IOException e) {
						e.printStackTrace();
					}
					album.setImage(QiNiuImageUploadUtil.webUrlPrfix+filename);
			}
			albumService.update(album);
			
			//保存
		}else if("save".equals(cmd)){
			if(!file.isEmpty()){
				
				//上传图片
				String uuidStr=UUID.randomUUID().toString().replace("-", "");
				String filename="upload/"+uuidStr+"."+file.getContentType().substring(file.getContentType().indexOf("/")+1);
				try {
					//将文件上传到七牛云
					new QiNiuImageUploadUtil().upload(file.getBytes(),filename);
				} catch (IOException e) {
					e.printStackTrace();
				}
				album.setImage(QiNiuImageUploadUtil.webUrlPrfix+filename);
			}
			albumService.save(album);
		}
		return "redirect:/admin/albumList.htm";
	} 
	
	/**
	 * 高级查询,分页
	 * @param qo
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/albumList")
	public String adminQuery(AlbumQueryObject qo,Model model){
		
		PageResult pageResult=albumService.query(qo);
		model.addAttribute("pageResult",pageResult);
		model.addAttribute("qo",qo);
		return "/admin/albumList";
	}
}
