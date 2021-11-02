package com.test.trees.controller;

import com.test.trees.controller.request.StorageRequest;
import com.test.trees.controller.request.TreeRequest;
import com.test.trees.controller.response.StorageResponse;
import com.test.trees.controller.response.TreeResponse;
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

    public List<TreeResponse> treeResponses(List<Tree> trees) {
        List<TreeResponse> treeResponses = new ArrayList<>();
        for (Tree tree : trees) {
            treeResponses.add(tree.treeResponse());
        }
        return treeResponses;
    }
    //get all trees
    @GetMapping("/trees")
    public List<TreeResponse> getAllTrees(){
        return this.treeResponses(treeService.getAllTrees());
    }
    //get tree by Id
    @GetMapping("/tree/{id}")
    public TreeResponse getTreeById(@PathVariable(value = "id") Long id){
        return treeService.getTreeById(id).treeResponse();
    }
    //Add new Tree
    @PostMapping(value = "/tree", consumes = "application/json")
    public TreeResponse addNewTree(@RequestBody TreeRequest treeRequest){
        return treeService.addNewTree(treeRequest.treeC(), treeRequest.getStorageId()).treeResponse();
    }
    //update tree
    @PutMapping(value = "/tree-update")
    public TreeResponse updateTreeDetails(@RequestParam Long id, TreeRequest treeRequest){
        return treeService.updateTreeDetails(treeRequest.treeI(id)).treeResponse();
    }
    //exclude
    @DeleteMapping("/tree/{id}")
    public void excludeTree(@PathVariable Long id){
        treeService.excludeTree(id);
    }
}
