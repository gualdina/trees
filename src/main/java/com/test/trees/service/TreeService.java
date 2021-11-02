package com.test.trees.service;

import com.test.trees.controller.exception.StorageNotFound;
import com.test.trees.controller.exception.TreeNotFound;
import com.test.trees.controller.request.TreeRequest;
import com.test.trees.model.Storage;
import com.test.trees.model.Tree;
import com.test.trees.repository.StorageRepository;
import com.test.trees.repository.VolunteerRepository;
import org.springframework.stereotype.Service;
import com.test.trees.repository.TreeRepository;

import java.util.List;

@Service
public class TreeService {
    private final TreeRepository treeRepository;
    private final VolunteerRepository volunteerRepository;
    private final StorageRepository storageRepository;

    public TreeService(TreeRepository treeRepository, VolunteerRepository volunteerRepository, StorageRepository storageRepository) {
        this.treeRepository = treeRepository;
        this.volunteerRepository = volunteerRepository;
        this.storageRepository = storageRepository;
    }
    //get Tree by id
    public Tree getTreeById(Long id) {
        return treeRepository.findById(id).orElseThrow(TreeNotFound::new);
    }
    //get all Trees
    public List<Tree> getAllTrees() {
        return treeRepository.findAll();
    }
    //Add new Tree
    public Tree addNewTree(Tree tree, Long storageId) {
        Storage storage = storageRepository.findById(storageId).orElseThrow(StorageNotFound::new);
        tree.setStorage(storage);
        return treeRepository.save(tree);
    }

    //exclude a Tree
    public Tree excludeTree(Long id){
        Tree tree= getTreeById(id);
        treeRepository.delete(tree);
        return tree;
    }
    // update Tree
    public Tree updateTreeDetails(Tree tree) {
        Tree treeToUpdate = this.getTreeById(tree.getId());
        return treeRepository.save(treeToUpdate);
    }
}
