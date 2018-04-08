package com.hemf.testweb.service.impl;

import com.hemf.testweb.mapper.TbItemCatMapper;
import com.hemf.testweb.pojo.EUTreeNode;
import com.hemf.testweb.pojo.TbItemCat;
import com.hemf.testweb.pojo.TbItemCatExample;
import com.hemf.testweb.service.IItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements IItemCatService {
    @Autowired
    TbItemCatMapper itemCatMapper;

    @Override
    public List<EUTreeNode> getCatList(Long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> itemCats = itemCatMapper.selectByExample(example);

        List<EUTreeNode> reList = new ArrayList<>();
        itemCats.forEach((item) -> {
            EUTreeNode treeNode = new EUTreeNode();
            treeNode.setId(item.getId());
            treeNode.setText(item.getName());
            treeNode.setState(item.getIsParent() ? "closed" : "open");

            reList.add(treeNode);
        });
        return reList;
    }
}
