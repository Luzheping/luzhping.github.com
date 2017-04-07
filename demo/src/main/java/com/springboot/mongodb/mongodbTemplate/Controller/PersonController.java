package com.springboot.mongodb.mongodbTemplate.Controller;

import com.springboot.mongodb.mongodbTemplate.Exception.FollowupException;
import com.springboot.mongodb.mongodbTemplate.Form.PersonSaveForm;
import com.springboot.mongodb.mongodbTemplate.Response.PageResult;
import com.springboot.mongodb.mongodbTemplate.Response.PageResultUtils;
import com.springboot.mongodb.mongodbTemplate.Response.Responses;
import com.springboot.mongodb.mongodbTemplate.Response.Result;
import com.springboot.mongodb.mongodbTemplate.domain.Person;
import com.springboot.mongodb.mongodbTemplate.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Created by luzhp on 2017/4/6.
 */

@RestController
@RequestMapping("springboot/mongodb/demo")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping(value = "save",method = RequestMethod.POST, produces = "application/json")
    public Result<Object> save(@RequestBody @Validated PersonSaveForm form , BindingResult result) {
        if (result.hasErrors()) {
            return Result.error(result.getFieldErrors());
        }
        try {
            return Result.success(service.save(form.toDomain()));
        } catch (FollowupException e) {
            return Result.error(e.getCode(), e.getMessage());
        }
    }

    @RequestMapping(value = "update",method = RequestMethod.POST, produces = "application/json")
    public Result<Object> update(@RequestBody @Validated PersonSaveForm form , BindingResult result) {
        if (result.hasErrors()) {
            return Result.error(result.getFieldErrors());
        }
        try {
            return Result.success(service.update(form.toDomain()));
        } catch (FollowupException e) {
            return Result.error(e.getCode(), e.getMessage());
        }
    }

    @RequestMapping(value = "delete",method = RequestMethod.GET , produces = "application/json")
    public Result<Object> delete(@RequestParam(value = "ids" , required = true) List<String> ids) {
        try {
            service.delete(ids);
            return Result.success(Responses.ids(ids));
        } catch (FollowupException e) {
            return Result.error(e.getCode(), e.getMessage());
        }
    }

    @RequestMapping(value = "query",method = RequestMethod.GET , produces = "application/json")
    public PageResult<Person> query(
            @RequestParam(required = false, defaultValue = "0") @Min(0) int startPage,
            @RequestParam(value = "page", required = false, defaultValue = "0") @Min(0) int page,
            @RequestParam(value = "rows", required = false, defaultValue = "15")@Min(0) @Max(500) int size) {
        try {
            int currPage = PageResultUtils.page(startPage, page);
            return PageResult.success(service.query(currPage, size)).setPage(page).setSize(size);
        } catch (FollowupException e) {
            return PageResult.error(e.getCode() , e.getMessage());
        }
    }

    @RequestMapping(value = "get",method = RequestMethod.GET,produces = "application/json")
    public Result<Person> get(@RequestParam(value = "id" , required = true) String id) {
        try {
            return Result.success(service.get(id));
        } catch (FollowupException e) {
            return Result.error(e.getCode(), e.getMessage());
        }
    }

}
