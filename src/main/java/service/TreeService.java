package service;

import model.Tree;
import model.Volunteer;
import org.springframework.stereotype.Service;
import repository.TreeRepository;

import java.util.List;

@Service
public class TreeService {
    private final TreeRepository treeRepository;

    public TreeService(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }
    //get Tree by id
    public Tree getTreeById(Long id) {
        return treeRepository.findById(id);
    }
    //get all Trees
    public List<Tree> getAllTrees() {
        return treeRepository.findAll();
    }
    //Add new Tree
    public Tree addNewTree(Tree tree) {
        return treeRepository.save(tree);
    }
    //exclude a Tree
    public Tree excludeTree(Long id){
        Tree tree= getTreeById(id);
        treeRepository.delete(tree);
        return tree;
    }
    // update Tree
    public Tree updateTreeDetails(Long id, AddNewTreeRequest addNewTreeRequest) {
        Tree treeToUpdate = getTreeById(id);
        treeToUpdate.setType( AddNewTreeRequest.getType());
        treeToUpdate.setRoots( AddNewTreeRequest.getRoots());
        treeToUpdate.setSize( AddNewTreeRequest.getSize());
        return treeToUpdate;
    }
}
