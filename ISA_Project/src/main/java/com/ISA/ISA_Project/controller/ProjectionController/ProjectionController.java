package com.ISA.ISA_Project.controller.ProjectionController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ISA.ISA_Project.controller.ProjectionController.dto.ProjectionDTO;
import com.ISA.ISA_Project.controller.dto.MessageResponseDTO;
import com.ISA.ISA_Project.domain.Projection;
import com.ISA.ISA_Project.domain.User;
import com.ISA.ISA_Project.service.ProjectionService;

@RestController
@RequestMapping("/projection")
public class ProjectionController {

	@Autowired
	private ProjectionService projectionService;

	@PostMapping("/createprojection")
	public MessageResponseDTO registration(@RequestBody ProjectionDTO projectionDTO) {
		
		Projection projection = new Projection();
		//Treba dodati hale,termine i cenu
		projection.setDirector(projectionDTO.getDirector());
		projection.setActors(projectionDTO.getActors());
		projection.setGeners(projectionDTO.getGeners());
		projection.setRuntime(projectionDTO.getRuntime());
		projection.setPoster(projectionDTO.getPoster());
		projection.setStoryline(projectionDTO.getStoryline());
		if(!(projectionService.checkUniqueName(projectionDTO.getName()))) {
        	return new MessageResponseDTO("Projection with that name already exists.");
        }
		projection.setName(projectionDTO.getName());
		
		Projection temp = projectionService.createProjection(projection);

        if(temp == null){
            return new MessageResponseDTO("Projection is not added.");
        }
		
		return new MessageResponseDTO("Projection is added.");
	}
}
