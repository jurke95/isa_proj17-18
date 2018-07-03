package com.ISA.ISA_Project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.domain.Friendship;
import com.ISA.ISA_Project.domain.User;
import com.ISA.ISA_Project.repository.FriendshipRepository;
import com.ISA.ISA_Project.repository.UserRepository;

@Service
public class FriendshipService {

	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FriendshipRepository friendshipRepository;
	
	
	

	
	public Friendship addfriendship(Long idone, Long idtwo) {
		
		User userone = userRepository.findOne(idone);
		
		if(!(userone==null)) {
			User usertwo = userRepository.findOne(idtwo);
			if(!(usertwo==null)) {
				
				Friendship friendship = new Friendship();
				friendship.setFirstfriend(userone);
				friendship.setSecondfriend(usertwo);
				friendship.setStatus("pending");
				friendshipRepository.save(friendship);
				return friendship;
				
			}
		}
		
		
		return null;
	}

	
	
	public List<Friendship> getfriendrequest(Long idtwo) {
		
		List<Friendship> request = friendshipRepository.findBySecondfriend_idEquals(idtwo);
		List<Friendship> retList = new ArrayList<>();
		if(!(request==null)) {
			for(int i=0;i<request.size();i++) {

				if(request.get(i).getStatus().equals("pending")) {
					retList.add(request.get(i));
				}
				
				
			}
			return retList;
		}
		return null;
	}


	
	public Friendship acceptrequest(Long idf) {
		
		Friendship frinedship = friendshipRepository.findByIdEquals(idf);
		
		if(!(frinedship==null)) {
			frinedship.setStatus("accepted");
			friendshipRepository.save(frinedship);
			return frinedship;
		}
		
		return null;
	}


	
	public Friendship declinerequest(Long idf) {
		
		Friendship friendship = friendshipRepository.findByIdEquals(idf);
		
		if(!(friendship==null)) {
			friendship.setStatus("declined");
			friendshipRepository.save(friendship);
			return friendship;
		}
		
		return null;

	}


	
	public List<User> getfriends(Long id) {
		
		ArrayList<User> listUsers = new ArrayList<>();
		
		List<Friendship> friendships1 = friendshipRepository.findByFirstfriend_idEquals(id);

		if(!(friendships1==null)) {
			for(int i=0; i<friendships1.size();i++) {

				if(friendships1.get(i).getStatus().equals("accepted")) {
					User user = userRepository.findOne(friendships1.get(i).getSecondfriend().getId());
					listUsers.add(user);
				}
			}
	
		}
		
		
		List<Friendship> friendships2 = friendshipRepository.findBySecondfriend_idEquals(id);

		if(!(friendships2==null)) {
			for(int i=0; i<friendships2.size();i++) {

				if(friendships2.get(i).getStatus().equals("accepted")) {
					User user = userRepository.findOne(friendships2.get(i).getFirstfriend().getId());
					listUsers.add(user);
				}
			}
		
		}
		
		if(!(listUsers==null)) {
			return listUsers;
		}
		
		
		
	
		
		return null;
	}

	
}
