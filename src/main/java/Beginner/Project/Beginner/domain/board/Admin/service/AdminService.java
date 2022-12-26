package Beginner.Project.Beginner.domain.board.Admin.service;

import Beginner.Project.Beginner.domain.board.Admin.repository.AdminRepository;
import Beginner.Project.Beginner.domain.board.Admin.dto.request.AdminParam;
import Beginner.Project.Beginner.domain.board.Admin.dto.response.AdminResult;
import Beginner.Project.Beginner.domain.board.Admin.entity.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AdminService {


    private final AdminRepository adminRepository;

    @Transactional
    public List<Admin> all(){
        List<Admin> admin =adminRepository.findAll();
        return admin;
    }

    @Transactional
    public Object write (Long seq){
        return adminRepository.findById(seq).map(Admin -> {
            AdminResult adminResult = new AdminResult();
            adminResult.setContent(Admin.getContent());
            adminResult.setUsername(Admin.getUsername());
            adminResult.setTitle(Admin.getTitle());
            adminResult.setSeq(Admin.getSeq());
            return adminResult;
        }).get();
    }


    @Transactional
    public void edit(AdminParam param){
        Admin getEntity = adminRepository.findByUsername(param.getUsername())
                .orElseThrow( () ->new RuntimeException());
        getEntity.update(param);
        adminRepository.save(getEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void add(AdminParam param){
        Admin admin = Admin.builder()
                .title(param.getTitle())
                .content(param.getContent())
                .username(param.getUsername())
                .build();

        adminRepository.save(admin);
    }

    @Transactional
    public void delete(Long seq){
        adminRepository.deleteById(seq);
    }

}
