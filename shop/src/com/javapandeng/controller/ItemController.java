package com.javapandeng.controller;

import com.github.pagehelper.Page;
import com.javapandeng.base.BaseController;
import com.javapandeng.po.Item;
import com.javapandeng.po.ItemCategory;
import com.javapandeng.service.ItemCategoryService;
import com.javapandeng.service.ItemService;
import com.javapandeng.utils.Pager;
import com.javapandeng.utils.SystemContext;
import com.javapandeng.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created with IDEA
 * auther:Natuos
 * Date:2021/8/4
 * Time:17:43
 */

@Controller
@RequestMapping("/item")
public class ItemController extends BaseController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemCategoryService itemCategoryService;
    /**
     * 分页查询类目列表
     */
    @RequestMapping("/findBySql")
    public String findBySql(Model model, Item item){
        String sql="select * from item where isDelete = 0 ";
        if(!isEmpty(item.getName())){
            sql+=" and name like '%"+item.getName()+"%' ";
        }
        sql+=" order by id desc";
        Pager<Item> pagers=itemService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",item);
        return "item/item";
    }

    /**
     * 添加商品入口
     */
    @RequestMapping("/add")
    public String add(Model model){
        String sql="select * from item_category where isDelete=0 and pid is not null order by id";
        List<ItemCategory> listBySqlReturnEntity = itemCategoryService.listBySqlReturnEntity(sql);
        model.addAttribute("types",listBySqlReturnEntity);
        return "item/add";
    }
    /**
     * 执行添加商品（提交）
     */
    @RequestMapping("/exAdd")
    public String exAdd(Item item, @RequestParam("file")CommonsMultipartFile[] files, HttpServletRequest request) throws IOException {
        //要上传文件
        itemCommon(item, files, request);
        item.setGmNum(0);
        item.setIsDelete(0);
        item.setScNum(0);
        itemService.insert(item);
        return "redirect:/item/findBySql.action";
    }

    /**
     * 修改商品入口
     */
    @RequestMapping("/update")
    public String update(Integer id,Model model){
        Item obj=itemService.load(id);
        String sql="select * from item_category where isDelete=0 and pid is not null order by id";
        List<ItemCategory> listBySqlReturnEntity = itemCategoryService.listBySqlReturnEntity(sql);
        model.addAttribute("types",listBySqlReturnEntity);
        model.addAttribute("obj",obj);
        return "item/update";
    }


    /**
     * 执行修改商品
     */
    @RequestMapping("/exUpdate")
    public String exUpdate(Item item, @RequestParam("file")CommonsMultipartFile[] files, HttpServletRequest request) throws IOException {
        //要上传文件
        itemCommon(item, files, request);
        itemService.updateById(item);
        return "redirect:/item/findBySql.action";
    }

    private void itemCommon(Item item, CommonsMultipartFile[] files, HttpServletRequest request) throws IOException {
        if(files.length>0){
            for(int s = 0; s< files.length; s++){
                //生成一个随机数
                String n= UUIDUtils.create();
                //             获取系统上下文的路径          +         指定下载路径   +    随机数  +     获取文件原始文件名  =新文件url（具有唯一性）
                String path= SystemContext.getRealPath()+"\\resource\\ueditor\\upload\\"+n+ files[s].getOriginalFilename();
                File newFile=new File(path);
                //通过CommonsMultipartFile的方法直接写文件
                files[s].transferTo(newFile);
                if(s==0){
                    item.setUrl1(request.getContextPath()+"\\resource\\ueditor\\upload\\"+n+ files[s].getOriginalFilename());
                }
                if(s==1){
                    item.setUrl2(request.getContextPath()+"\\resource\\ueditor\\upload\\"+n+ files[s].getOriginalFilename());
                }
                if(s==2){
                    item.setUrl3(request.getContextPath()+"\\resource\\ueditor\\upload\\"+n+ files[s].getOriginalFilename());
                }
                if(s==3){
                    item.setUrl4(request.getContextPath()+"\\resource\\ueditor\\upload\\"+n+ files[s].getOriginalFilename());
                }
                if(s==4){
                    item.setUrl5(request.getContextPath()+"\\resource\\ueditor\\upload\\"+n+ files[s].getOriginalFilename());
                }
            }
        }
        ItemCategory byId = itemCategoryService.getById(item.getCategoryIdTwo());
        item.setCategoryIdOne(byId.getPid());
    }

    /**
     * 商品下架
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        Item obj=itemService.load(id);
        obj.setIsDelete(1);
        itemService.updateById(obj);
        return "redirect:/item/findBySql.action";
    }

    /**
     * 前端主页面：按关键字或者二级分类查询
     */
    @RequestMapping("/shoplist")
    public String shoplist(Item item,String condition,Model model){

        String sql="select * from item where isDelete=0 ";
        if(!isEmpty(item.getCategoryIdTwo())){
            sql+=" and category_id_two="+item.getCategoryIdTwo();
        }
        if(!isEmpty(condition)){
            sql+=" and name like '%"+condition+"%' ";
            model.addAttribute("condition", condition);
        }
        if(!isEmpty(item.getPrice())){
            sql+=" order by (price+0) desc";
        }
        if(!isEmpty(item.getGmNum())){
            sql+=" order by gmNum desc";
        }
        if(isEmpty(item.getPrice())&&isEmpty(item.getGmNum())){
            sql+=" order by id desc";
        }
        Pager<Item> pagers = itemService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers", pagers);
        model.addAttribute("obj", item);
        return "item/shoplist";
    }

    @RequestMapping("/view")
    public String view(Integer id ,Model model){
        Item obj = itemService.load(id);
        model.addAttribute("obj", obj);
        return "item/view";
    }
}
