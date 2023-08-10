package pl.pingwit.postservice.postitems.service;

import pl.pingwit.postservice.postitems.controller.model.PostItemTypeDTO;

import java.util.List;

public interface PostItemsService {

    List<PostItemTypeDTO> getAllTypes();

    PostItemTypeDTO createType(PostItemTypeDTO typeToCreate);

    PostItemTypeDTO getById(Long id);

    void delete(Long id);
}
