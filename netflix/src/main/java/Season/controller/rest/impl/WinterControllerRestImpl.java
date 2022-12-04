package Season.controller.rest.impl;

import Season.controller.rest.WinterControllerRest;
import Season.controller.rest.mapper.WinterRestMapper;
import Season.controller.rest.model.WinterRest;
import Season.controller.rest.model.D4iPageRest;
import Season.controller.rest.model.D4iPaginationInfo;
import Season.controller.rest.model.BigBangResponse;
import Season.exception.BigBangException;
import Season.service.WinterService;
import Season.util.constant.CommonConstantsUtils;
import Season.util.constant.RestConstantsUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "Winter", description = "Winter rest")
public class WinterControllerRestImpl implements WinterControllerRest {

    private final WinterService winterService;
    private final WinterRestMapper winterRestMapper;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = RestConstantsUtils.RESOURCE_WINTER, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "getAllWinters", description = "Get all Winters paginated")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)
    })
    public BigBangResponse<D4iPageRest<WinterRest>> getAllWinters(
      @RequestParam(defaultValue = CommonConstantsUtils.ZERO) final int page,
	    @RequestParam(defaultValue = CommonConstantsUtils.TWENTY) final int size, 
      @Parameter(hidden = true) final Pageable pageable) throws BigBangException {
        final Page<WinterRest> winterRestList = winterService.getAllWinters(pageable).map(winter -> winterRestMapper.mapToRest(winter));
        return new BigBangResponse<>(HttpStatus.OK.toString(),
                                    String.valueOf(HttpStatus.OK.value()),
                                    CommonConstantsUtils.OK,
                                    new D4iPageRest<>(winterRestList.getContent().toArray(WinterRest[]::new),
                                        new D4iPaginationInfo(winterRestList.getNumber(),
                                                                pageable.getPageSize(),
                                                                winterRestList.getTotalPages())));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getWinterById", description = "Get one Winter by given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
    })
    @GetMapping(value = RestConstantsUtils.RESOURCE_WINTER + RestConstantsUtils.RESOURCE_WINTERID)
    public BigBangResponse<WinterRest> getWinterById(@PathVariable(value = RestConstantsUtils.WINTERID) final Long id)
	    throws BigBangException {
	return new BigBangResponse<>(HttpStatus.OK.toString(), String.valueOf(HttpStatus.OK.value()),
		CommonConstantsUtils.OK,winterRestMapper.mapToRest(winterService.getWinterById(id)));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = RestConstantsUtils.RESOURCE_WINTER)
    @Operation(summary = "WinterClient", description = "Create a new Winter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)
    })
    public BigBangResponse<WinterRest> createWinter(@RequestBody final WinterRest winter) throws BigBangException {
        final WinterRest winterRest = winterRestMapper.mapToRest(
                winterService.createWinter(winterRestMapper.mapToDto(winter)));
        return new BigBangResponse<>(HttpStatus.OK.toString(), String.valueOf(HttpStatus.OK.value()),
                                    CommonConstantsUtils.OK, winterRest);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "updateWinterStatus", description = "Update Winter status")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
    })
    @PutMapping(value = RestConstantsUtils.RESOURCE_WINTER)
    public BigBangResponse<WinterRest> updateWinter(@RequestBody final WinterRest winterRest) throws BigBangException {
	return new BigBangResponse<>(HttpStatus.OK.toString(), String.valueOf(HttpStatus.OK.value()),
		CommonConstantsUtils.OK,winterRestMapper.mapToRest(winterService.updateWinter(winterRestMapper.mapToDto(winterRest))));
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "deleteWinter", description = "Delete Winter by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @DeleteMapping(value = RestConstantsUtils.RESOURCE_WINTER + RestConstantsUtils.RESOURCE_WINTERID)
    public void deleteWinter(@PathVariable(value = RestConstantsUtils.WINTERID) final Long id)
	    throws BigBangException {
	      winterService.deleteWinter(id);
    }
}
