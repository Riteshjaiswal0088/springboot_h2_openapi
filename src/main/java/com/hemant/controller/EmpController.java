package com.hemant.controller;

import com.hemant.model.dto.EmpDto;
import com.hemant.model.dto.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmpController {

    @Operation(summary = "Get a Emp by its empId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the emp",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied"),
            @ApiResponse(responseCode = "404", description = "Emp not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)) }) })
    ResponseEntity<EmpDto> getEmpById(@PathVariable Integer id) ;

    @Operation(summary = "Get a All emp list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the emp List",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied"),
            @ApiResponse(responseCode = "404", description = "Emp List not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)) }) })
    ResponseEntity<List<EmpDto>> getAllEmp();

    @Operation(summary = "Save a Emp")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "2001", description = "Saved the emp",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied"),
            @ApiResponse(responseCode = "404", description = "Emp not saved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)) }) })
    ResponseEntity<EmpDto> saveEmp(@RequestBody EmpDto empDto);

    @Operation(summary = "Delete a Emp by its empId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "deleted the emp",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied"),
            @ApiResponse(responseCode = "404", description = "Emp not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)) }) })
    ResponseEntity<String> deleteEmp(@PathVariable Integer empId);
}
