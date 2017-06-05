package com.zml.nekopara.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import com.zml.nekopara.model.Advert;
import com.zml.nekopara.model.AdvertPosition;
import com.zml.nekopara.model.AdvertQueryObject;
import com.zml.nekopara.service.IAdvertPositionService;
import com.zml.nekopara.service.IAdvertService;
import com.zml.nekopara.util.PageResult;
import com.zml.nekopara.util.QiNiuImageUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AdvertController {

	@Autowired
	private IAdvertService advertService;
	@Autowired
	private IAdvertPositionService advertPositionService;

	/**
	 * =============================后台==================================
	 */
	
	/**
	 * 编辑页面
	 * @return
	 */
	@RequestMapping("/admin/advertEditPage")
	public String adEditPage(Long id,Long apid,String cmd,Model model){
		List<AdvertPosition> aps = advertPositionService.findAll();
		model.addAttribute("aps",aps);
		if(apid!=null){
			AdvertPosition ap = advertPositionService.get(apid);
			model.addAttribute("ap",ap);
		}
		//更新
		if(id!=null){
			if("edit".equals(cmd)){
				Advert advert = advertService.get(id);
				model.addAttribute("advert",advert);
			}
		}
		
		model.addAttribute("cmd",cmd);
		return "/admin/advertEdit";
	}
	
	/**
	 * 保存或者更新
	 * @param article
	 * @param cmd
	 * @return
	 */
	@RequestMapping("/admin/advertEdit")
	public String articleEdit(Advert advert,String cmd,MultipartFile file){
		//编辑
		if("edit".equals(cmd)){
			//如果没有上传图片就不修改原来的图片
			Advert oldAd = advertService.get(advert.getId());
			if(file.isEmpty()){
				advert.setImage(oldAd.getImage());
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
					advert.setImage(QiNiuImageUploadUtil.webUrlPrfix+filename);
			}
			advertService.update(advert);
			
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
				advert.setImage(QiNiuImageUploadUtil.webUrlPrfix+filename);
			}
			advertService.save(advert);
		}
		return "redirect:/admin/advertList.htm";
	} 
	
	/**
	 * 高级查询,分页
	 * @param qo
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/advertList")
	public String adminQuery(AdvertQueryObject qo, Model model){
		
		PageResult pageResult=advertService.query(qo);
		model.addAttribute("pageResult",pageResult);
		model.addAttribute("qo",qo);
		return "/admin/advertList";
	}
}
