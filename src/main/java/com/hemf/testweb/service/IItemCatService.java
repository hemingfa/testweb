package com.hemf.testweb.service;

import com.hemf.testweb.pojo.EUTreeNode;

import java.util.List;

public interface IItemCatService {
    List<EUTreeNode> getCatList(Long parentId);
}
