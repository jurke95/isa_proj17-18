package com.ISA.ISA_Project.controller.FriendshipController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ISA.ISA_Project.controller.dto.MessageResponseDTO;
import com.ISA.ISA_Project.domain.Friendship;
import com.ISA.ISA_Project.domain.User;
import com.ISA.ISA_Project.service.FriendshipService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/friendship")
public class FriendshipController {

	
	@Autowired
	private FriendshipService friendshipService;
	
	
	
	@PostMapping("/addFriendship")
	public MessageResponseDTO addFriendship(@RequestParam("idone") Long idone,@RequestParam("idtwo") Long idtwo){
		
		
		Friendship friendship=friendshipService.addfriendship(idone, idtwo);
		
		if(!(friendship==null)) {
			return new MessageResponseDTO("Successfully added friendship");
		}
		return new MessageResponseDTO("Cannot add friendship");
		
	}
	
	@GetMapping("/getFriendRequest/{idtwo}")
	public MessageResponseDTO getFriendRequest(@PathVariable("idtwo") Long idtwo){
		
		
		List<Friendship> friendship=friendshipService.getfriendrequest(idtwo);
		
		if(!(friendship==null)) {
			return new MessageResponseDTO("Successfully got friendship");
		}
		return new MessageResponseDTO("Cannot get friendship");
		
	}
	
	
	@PostMapping("/acceptRequest/{idf}")
	public MessageResponseDTO acceptRequest(@PathVariable("idf") Long idf){
		
		
		Friendship friendship=friendshipService.acceptrequest(idf);
		
		if(!(friendship==null)) {
			return new MessageResponseDTO("Successfully accepted friend request");
		}
		return new MessageResponseDTO("Cannot accept friend request");
		
	}
	
	
	@PostMapping("/declineRequest/{idf}")
	public MessageResponseDTO declineRequest(@PathVariable("idf") Long idf){
		
		
		Friendship friendship=friendshipService.declinerequest(idf);
		
		if(!(friendship==null)) {
			return new MessageResponseDTO("Successfully declined friend request");
		}
		return new MessageResponseDTO("Cannot decline friend request");
		
	}
	
	
	@GetMapping("/getFriend/{idone}")
	public List<User> getFriend(@PathVariable("idone") Long idone){
		
		
		List<User> friends=friendshipService.getfriends(idone);
		return friends;
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
