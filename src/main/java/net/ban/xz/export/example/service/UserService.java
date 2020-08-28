package net.ban.xz.export.example.service;

import net.ban.xz.export.example.dto.ExportUserDto;
import net.ban.xz.export.example.repo.UserRepository;
import net.ban.xz.export.util.PoiExcelExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void exportUser(OutputStream outputStream) {

        List<ExportUserDto> collect = userRepository.findAll().stream()
                .map(ExportUserDto::from)
                .collect(Collectors.toList());

        collect.forEach((e) -> e.setSerial(collect.indexOf(e)+1));

        String[] heads = {"序号", "用户名", "真实姓名", "电话", "邮箱", "是否锁定", "是否删除","创建时间", "删除时间"};
        String[] cols = {"serial", "userName", "realName", "phone", "email", "locked","deleted", "createTime", "updateTime"};
        PoiExcelExport<ExportUserDto> excelExport = new PoiExcelExport<>(heads, cols, collect, outputStream);
        excelExport.exportExcel();

    }

}
