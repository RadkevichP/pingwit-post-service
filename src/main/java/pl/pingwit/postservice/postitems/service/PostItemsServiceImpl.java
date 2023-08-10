package pl.pingwit.postservice.postitems.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pingwit.postservice.exception.PostServiceNotFoundException;
import pl.pingwit.postservice.postitems.controller.model.PostItemTypeDTO;
import pl.pingwit.postservice.postitems.converter.PostItemTypeConverter;
import pl.pingwit.postservice.postitems.repository.PostItemType;
import pl.pingwit.postservice.postitems.repository.PostItemTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PostItemsServiceImpl implements PostItemsService {

    private final PostItemTypeRepository repository;
    private final PostItemTypeConverter converter;

    public PostItemsServiceImpl(PostItemTypeRepository repository, PostItemTypeConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public List<PostItemTypeDTO> getAllTypes() {
        return converter.convertToDto(repository.findAll());
    }

    @Transactional
    @Override
    public PostItemTypeDTO createType(PostItemTypeDTO typeToCreate) {
        PostItemType postItemType = converter.convertToEntity(typeToCreate);
        PostItemType saved = repository.save(postItemType);
        return converter.convertToDto(saved);
    }

    @Override
    public PostItemTypeDTO getById(Long id) {

        PostItemType postItemType = repository.findById(id).orElseThrow(() -> new PostServiceNotFoundException("Type not found!"));
        return converter.convertToDto(postItemType);
    }

    @Override
    public void delete(Long id) {

    }
}
