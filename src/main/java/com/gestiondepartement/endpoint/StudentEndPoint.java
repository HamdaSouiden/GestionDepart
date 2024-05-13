package com.gestiondepartement.endpoint;

import allapis.springbootsoap.com.*;
import com.gestiondepartement.Entity.Students;
import com.gestiondepartement.Service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentEndPoint {
    private static final String NameSpace_URI="http://com.springbootsoap.allapis";
    @Autowired
    private StudentService studentService;
    @PayloadRoot(namespace = NameSpace_URI, localPart= "addStudentRequest")
    @ResponsePayload
    public AddStudentResponse addStudent (@RequestPayload AddStudentResponse request) {
        AddStudentResponse response=new AddStudentResponse();
        ServiceStatusStudent serviceStatus=new ServiceStatusStudent();
        Students student =new Students();
        BeanUtils.copyProperties((request.getStudentInfo()), student);
        studentService.addStudent(student);
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Added Successfully");
        response.setServiceStatusStudent(serviceStatus);
        return response;
    }
    @PayloadRoot (namespace = NameSpace_URI, localPart= "getStudentByIdRequest")
    @ResponsePayload
    public GetStudentResponse getStudent (@RequestPayload GetStudentByIdRequest request) {
        GetStudentResponse response=new GetStudentResponse();
        StudentInfo studentInfo =new StudentInfo();

        BeanUtils.copyProperties(studentService.getStudentById(request.getStudentId()), studentInfo);
        response.setStudentInfo(studentInfo);
        return response;

    }
    @PayloadRoot (namespace = NameSpace_URI, localPart= "updateStudentRequest")
    @ResponsePayload
    public UpdateStudentResponse updateStudent (@RequestPayload UpdateStudentRequest request) {
        Students student =new Students();
        BeanUtils.copyProperties(request.getStudentInfo(), student);
        studentService.updateStudent(student);
        ServiceStatusStudent serviceStatus =new ServiceStatusStudent();
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Update Successfully");
        UpdateStudentResponse response= new UpdateStudentResponse();
        response.setServiceStatusStudent(serviceStatus);
        return response;
    }
    @PayloadRoot (namespace = NameSpace_URI, localPart= "deleteStudentRequest")
    @ResponsePayload
    public DeleteStudentResponse deleteStudent (@RequestPayload DeleteStudentRequest request) {
        studentService.deleteStudent(request.getStudentId());
        ServiceStatusStudent serviceStatus =new ServiceStatusStudent();

        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content deleted Successfully");
        DeleteStudentResponse response = new DeleteStudentResponse();
        response.setServiceStatusStudent(serviceStatus);
        return response;
    }
}
