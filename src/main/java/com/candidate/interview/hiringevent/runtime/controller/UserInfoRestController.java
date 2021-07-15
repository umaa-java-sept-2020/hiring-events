package com.candidate.interview.hiringevent.runtime.controller;

import com.candidate.interview.hiringevent.runtime.model.UserInfo;
import com.candidate.interview.hiringevent.runtime.service.UserInfoModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/user-info")
public class UserInfoRestController extends AbstractRestController<UserInfo, Integer> {

    @Autowired
    private UserInfoModelService userInfoModelService;


    @PostMapping("/")
    @Override
    public ResponseEntity<UserInfo> createResource(@RequestBody  UserInfo body, HttpServletRequest request) {
        System.out.println(body.isMockUser());
        UserInfo userInfo = userInfoModelService.save(body);
        return ResponseEntity.ok(userInfo);
    }

    @Override
    public ResponseEntity<UserInfo> updateResource(UserInfo body, Integer id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<UserInfo> getResource(Integer id, HttpServletRequest request) {
        return null;
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<List<UserInfo>> getResources(HttpServletRequest request) {
        List<UserInfo> userInfos = userInfoModelService.findAll();
        return ResponseEntity.ok(userInfos);
    }

    @Override
    public ResponseEntity<Integer> deleteResource(Integer id, HttpServletRequest request) {
        return null;
    }
}
