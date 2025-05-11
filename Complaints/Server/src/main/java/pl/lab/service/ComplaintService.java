package pl.lab.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import pl.lab.data.ComplaintRepository;
import pl.lab.dto.ComplaintDTO;
import pl.lab.entities.Complaint;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import java.util.List;
import java.lang.reflect.Type;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ComplaintService {

    @Inject
    private ComplaintRepository complaintRepository;

    @Inject
    private ModelMapper modelMapper;


    public List<ComplaintDTO> findAll(String status) {
        ModelMapper mapper = new ModelMapper();
        List<Complaint> entityList = complaintRepository.findAll(status);
        Type listType = new TypeToken<List<ComplaintDTO>>() {}.getType();

        return mapper.map(entityList, listType);
    }

    public ComplaintDTO find(Long id) {
        Complaint complaint = complaintRepository.find(id);
        return modelMapper.map(complaint, ComplaintDTO.class);
    }

    @Transactional
    public void create(ComplaintDTO complaintDTO) {
        Complaint complaint = modelMapper.map(complaintDTO, Complaint.class);
        complaintRepository.create(complaint);
    }

    @Transactional
    public void edit(ComplaintDTO complaintDTO) {
        Complaint complaint = modelMapper.map(complaintDTO, Complaint.class);
        complaintRepository.edit(complaint);
    }

    @Transactional
    public void remove(ComplaintDTO complaintDTO) {
        Complaint complaint = modelMapper.map(complaintDTO, Complaint.class);
        complaintRepository.remove(complaint);
    }
}
