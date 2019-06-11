package com.primsis.smm.ws.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.primsis.core.base.util.PrimsisWebServiceReponse;
import com.primsis.smm.entity.SmmHeaderForm;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * @author abdulkerim.ATIK
 *
 */
public interface SmmApi  {
	
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "Post of available load new smm", response = PrimsisWebServiceReponse.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value="/load" ,method = RequestMethod.POST)
	public PrimsisWebServiceReponse loadSmm(@RequestBody SmmHeaderForm requestForm) ;

	
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "Post of available send new smm", response = PrimsisWebServiceReponse.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value="/send" ,method = RequestMethod.POST)
	public PrimsisWebServiceReponse sendSmm(@RequestBody SmmHeaderForm requestForm) ;

	
	@ApiOperation(value = "Get of available smm checkstatus", response = SmmHeaderForm.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value="/checkstatus/{uuid}" ,method = RequestMethod.GET)
	public SmmHeaderForm checkStatusSmm(@PathVariable("uuid") String uuid) ;

	
	@ApiOperation(value = "Get of available get  smm", response = PrimsisWebServiceReponse.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value="/get" ,method = RequestMethod.GET)
	public SmmHeaderForm getSmm(@RequestBody SmmHeaderForm requestForm) ;

	
	
}
