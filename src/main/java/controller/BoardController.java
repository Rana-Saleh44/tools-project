package controller;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import service.BoardService;


@PermitAll
@Path("/boards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BoardController {
	
	@EJB
	private BoardService boardService;
	
	@POST
	@Path("/create/{userId}/{name}")
	public Response createBoard(@PathParam("userId") Long userId, @PathParam("name")String name) {
		return boardService.createBoard(userId, name);
	}
	@GET
	@Path("/getAllBoardByTeamLeader/{teamLeaderId}")
	public Response getAllBoardByTeamLeader(@PathParam("teamLeaderId")Long teamLeaderId) {
		return Response.ok(boardService.getAllBoardsByTeamLeader(teamLeaderId)).build();
	}
	
}
