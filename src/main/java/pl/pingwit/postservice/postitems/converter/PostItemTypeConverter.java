package pl.pingwit.postservice.postitems.converter;

import org.springframework.stereotype.Component;
import pl.pingwit.postservice.postitems.controller.PostItemTypesController;
import pl.pingwit.postservice.postitems.controller.model.PostItemTypeDTO;
import pl.pingwit.postservice.postitems.repository.PostItemType;

import java.util.List;

@Component
public class PostItemTypeConverter {

    public PostItemTypeDTO convertToDto(PostItemType postItemType) {
        return mapToDto(postItemType);
    }

    public List<PostItemTypeDTO> convertToDto(List<PostItemType> postItemTypes) {
        return postItemTypes.stream()
                .map(this::mapToDto)
                .toList();
    }

    public PostItemType convertToEntity(PostItemTypeDTO postItemTypeDTO) {
        return new PostItemType(postItemTypeDTO.getId(), postItemTypeDTO.getName(), postItemTypeDTO.getBaseRate());
    }

    private PostItemTypeDTO mapToDto(PostItemType postItemType) {
        return new PostItemTypeDTO(postItemType.getId(), postItemType.getName(), postItemType.getBaseRate());
    }
}
