/*
 * Created under not commercial project "Make it fine"
 *
 * Copyright 2017-2021
 */

package com.stingion.makeitfine.controller

import com.stingion.makeitfine.data.model.Company
import com.stingion.makeitfine.data.service.model.CompanyService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping("company")
@Api(tags = ["CompanyController"])
class CompanyController(@Autowired val companyService: CompanyService) {
    @GetMapping
    @ApiOperation("Get all companies")
    fun listAllCompanies() = companyService.findAll()

    @GetMapping("{id}")
    @ApiOperation("Get company by Id")
    fun getCompany(
        @PathVariable
        @ApiParam(
            value = "Specify company id",
            defaultValue = "any positive number",
            required = true
        ) id: Int
    ): Company? = companyService.findById(id)
}
