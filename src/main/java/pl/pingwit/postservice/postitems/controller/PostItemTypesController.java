package pl.pingwit.postservice.postitems.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.postservice.postitems.controller.model.PostItemTypeDTO;
import pl.pingwit.postservice.postitems.service.PostItemsService;

import java.util.List;

@RestController
@RequestMapping("/post-item-types")
public class PostItemTypesController {

    private final PostItemsService postItemsService;

    public PostItemTypesController(PostItemsService postItemsService) {
        this.postItemsService = postItemsService;
    }

    @GetMapping
    public List<PostItemTypeDTO> findAll() {
        return postItemsService.getAllTypes();
    }



    @PostMapping
    public PostItemTypeDTO create(PostItemTypeDTO typeToCreate) {
        return postItemsService.createType(typeToCreate);
    }

}
