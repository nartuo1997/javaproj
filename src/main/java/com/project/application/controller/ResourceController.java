package com.project.application.controller;

import com.project.application.entity.Project;
import com.project.application.entity.ProjectColumns;
import com.project.application.entity.Resources;
import com.project.application.service.ProjectColumnsService;
import com.project.application.service.ResourcesDetailsService;
import com.project.application.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourcesService resourcesService;
    @Autowired
    private ProjectColumnsService projectColumnsService;
    @Autowired
    private ResourcesDetailsService resourceDetailsService;

//    @GetMapping("/read")
//    public ResponseEntity<?> read(){
//        String body = resourcesService.g //getAllJson();
//        String columnDetails = projectColumnsService.getColumnsJson(null);
//        return new ResponseEntity<>(String.format("{\"columnInfo\":%s,\"tableDetail\":%s}", columnDetails,body), HttpStatus.OK);
//    }
//
//    @PostMapping("/addColumn")
//    public ResponseEntity<?> addColumn(@RequestParam(name="columnName") String columnName){
//        Columns columnToAdd = new Columns(columnName);
//        boolean isSuccessful = projectColumnsService.create(columnToAdd);
//        if(isSuccessful){
//            return new ResponseEntity<>(columnToAdd,HttpStatus.OK);
//        }
//        return new ResponseEntity<>("{\"error\":\"column name taken!\"}",HttpStatus.BAD_REQUEST);
//    }
//
//    @PostMapping("/deleteColumn")
//    public ResponseEntity<?> deleteColumn(@RequestParam(name="columnName") String columnName){
//        Columns columnToDelete = projectColumnsService.get(null,columnName);
//        boolean isSuccessful = projectColumnsService.delete(columnToDelete);
//        if(isSuccessful){
//            return new ResponseEntity<>(columnToDelete,HttpStatus.OK);
//        }
//        return new ResponseEntity<>("{\"error\":\"column does not exist!\"}",HttpStatus.BAD_REQUEST);
//    }
//
//    @PostMapping("/updateColumn")
//    public ResponseEntity<?> deleteColumn(@RequestParam(name="oldColumnName") String oldColumnName,@RequestParam(name = "newColumnName")String newColumnName){
//        Columns columnToUpdate = projectColumnsService.get(null,oldColumnName);
//        boolean isSuccessful = projectColumnsService.update(columnToUpdate,newColumnName);
//        if(isSuccessful){
//            return new ResponseEntity<>(columnToUpdate,HttpStatus.OK);
//        }
//        return new ResponseEntity<>("{\"error\":\"column does not exist!\"}",HttpStatus.BAD_REQUEST);
//
//    }

    @PostMapping("/addresource")
    public ResponseEntity<?> addResource(){
        Resources resourceToAdd = new Resources();
        resourceToAdd.setLastUpdated(LocalDate.now());
        resourceToAdd.setTimeCreated(LocalDate.now());
        resourcesService.add(resourceToAdd);
        return new ResponseEntity<>(resourceToAdd, HttpStatus.OK);
    }

    @GetMapping("/getresource/{resourceId}")
    public ResponseEntity<?> getResource(@PathVariable Integer resourceId){
        Resources resources = resourcesService.get(resourceId);

        if(resources == null) {
            return new ResponseEntity<>("The project is not found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

//    @PostMapping("/deleteResource")
//    public ResponseEntity<?> deleteResource(@RequestParam(name = "resourceId")Integer resourceId){
//        Resource resourceToDelete = resourcesService.get(resourceId);
//        if(resourceToDelete==null){
//            return new ResponseEntity<>("{\"error\":\"resource does not exist!\"}",HttpStatus.BAD_REQUEST);
//        }
//        boolean isSuccessful = resourcesService.delete(resourceToDelete);
//        return new ResponseEntity<>(resourceToDelete, HttpStatus.OK);
//    }
//
//    @PostMapping("/setEntry")
//    public ResponseEntity<?> setEntry(@RequestParam(name = "resourceId")Integer resourceId,
//                                      @RequestParam(name = "columnId")Integer columnId,
//                                      @RequestParam(name = "value") String value){
//        Columns column = projectColumnsService.get(columnId);
//        if(column == null){
//            return new ResponseEntity<>("{\"error\":\"column does not exist!\"}",HttpStatus.BAD_REQUEST);
//        }
//        Resource resource = resourcesService.get(resourceId);
//        if(resource==null){
//            return new ResponseEntity<>("{\"error\":\"resource does not exist!\"}",HttpStatus.BAD_REQUEST);
//        }
//        ResourceDetails rd = resourceDetailsService.get(resource,column);
//        if(rd==null){
//            rd = new ResourceDetails();
//            rd.setColumnValue(value);
//            resourceDetailsService.create(rd,resource,column);
//            return new ResponseEntity<>(rd, HttpStatus.OK);
//        }
//        rd.setColumnValue(value);
//        boolean isSuccessful = resourceDetailsService.update(rd);
//        if(isSuccessful){
//            return new ResponseEntity<>(rd,HttpStatus.OK);
//        }
//        return new ResponseEntity<>("{\"error\":\"sth wrong happens:(\"}",HttpStatus.BAD_REQUEST);
//    }
}
