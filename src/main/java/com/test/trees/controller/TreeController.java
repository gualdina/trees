package com.test.trees.controller;

import com.test.trees.controller.request.AddNewStorageRequest;
import com.test.trees.controller.request.AddNewTreeRequest;
import com.test.trees.controller.response.StorageResponse;
import com.test.trees.controller.response.TreeResponse;
import com.test.trees.model.Storage;
import com.test.trees.model.Tree;
import com.test.trees.service.TreeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class TreeController {
    private final TreeService treeService;

    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }
    //get tree by Id
    @GetMapping("/tree/{id}")
    public TreeResponse getTreeById(@PathVariable Long id){
        Tree tree = treeService.getTreeById(id);
        return new TreeResponse(
                tree.getId(),
                tree.getType(),
                tree.getRoots(),
                tree.getSize()
        );
    }
    //get all trees
    @GetMapping("/trees")
    public List<TreeResponse> getAllTrees(){
        List<Tree> trees = treeService.getAllTrees();
        List<TreeResponse> treeResponseList = new ArrayList<>();
        for(Tree tree :trees){
            treeResponseList.add(new TreeResponse(
                    tree.getId(),
                    tree.getType(),
                    tree.getRoots(),
                    tree.getSize()
            ));
        }

        return treeResponseList;
    }
    //Add new Tree
    @PostMapping(value = "/tree", consumes = "application/json")
    public TreeResponse addNewTree(@RequestBody @Valid AddNewTreeRequest addNewTreeRequest){
        Tree tree = treeService.addNewTree(Tree.builder()
                .type(addNewTreeRequest.getType())
                .roots(addNewTreeRequest.getRoots())
                .size(addNewTreeRequest.getSize())
                .build());
        return new TreeResponse(
                tree.getId(),
                tree.getType(),
                tree.getRoots(),
                tree.getSize()
        );
    }
    //update Storage
    @DeleteMapping("/tree/{id}")
    public void excludeTree(@PathVariable Long id){
        treeService.excludeTree(id);
    }
}
