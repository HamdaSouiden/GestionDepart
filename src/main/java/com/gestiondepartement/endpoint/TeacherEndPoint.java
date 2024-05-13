package com.gestiondepartement.endpoint;

import allapis.springbootsoap.com.*;
import com.gestiondepartement.Entity.Teachers;
import com.gestiondepartement.Service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TeacherEndPoint {
    private static final String NameSpace_URI="http://com.springbootsoap.allapis";
    @Autowired
    private TeacherService teacherService;
    @PayloadRoot(namespace = NameSpace_URI, localPart= "addTeacherRequest")
    @ResponsePayload
    public AddTeacherResponse addTeacher (@RequestPayload AddTeacherResponse request) {
        AddTeacherResponse response =new AddTeacherResponse();
        ServiceStatusTeacher serviceStatus =new ServiceStatusTeacher();
        Teachers teacher =new Teachers();
        BeanUtils.copyProperties((request.getTeacherInfo()), teacher);
        teacherService.addTeacher(teacher);
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Added Successfully");
        response.setServiceStatusTeacher(serviceStatus);
        return response;
    }
    @PayloadRoot (namespace = NameSpace_URI, localPart= "getTeacherByIdRequest")
    @ResponsePayload
    public GetTeacherResponse getTeacher (@RequestPayload GetTeacherByIdRequest request) {
        GetTeacherResponse response =new GetTeacherResponse();
        TeacherInfo teacherInfo =new TeacherInfo();

        BeanUtils.copyProperties(teacherService.getTeacherById(request.getTeacherId()), teacherInfo);
        response.setTeacherInfo(teacherInfo);
        return response;

    }
    @PayloadRoot (namespace = NameSpace_URI, localPart= "updateTeacherRequest")
    @ResponsePayload
    public UpdateTeacherResponse updateTeacher (@RequestPayload UpdateTeacherRequest request) {
        Teachers teacher =new Teachers();
        BeanUtils.copyProperties(request.getTeacherInfo(), teacher);
        teacherService.updateTeacher(teacher);
        ServiceStatusTeacher serviceStatus =new ServiceStatusTeacher();
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Update Successfully");
        UpdateTeacherResponse response = new UpdateTeacherResponse();
        response.setServiceStatusTeacher(serviceStatus);
        return response;
    }
    @PayloadRoot (namespace = NameSpace_URI, localPart= "deleteTeacherRequest")
    @ResponsePayload
    public DeleteTeacherResponse deleteTeacher (@RequestPayload DeleteTeacherRequest request) {
        teacherService.deleteTeacher(request.getTeacherId());
        ServiceStatusTeacher serviceStatus = new ServiceStatusTeacher();

        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content deleted Successfully");
        DeleteTeacherResponse response = new DeleteTeacherResponse();
        response.setServiceStatusTeacher(serviceStatus);
        return response;
    }
}

