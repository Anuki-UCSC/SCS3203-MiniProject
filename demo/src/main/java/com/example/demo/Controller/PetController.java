package com.example.demo.Controller;


import com.example.demo.Model.Pet;
import com.example.demo.Service.PetService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pet")
@Transactional
public class PetController {

    @Inject
    PetService petService;


    //display pet details
    @GET
    @Path("/getDetails")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List of all the Pets Details ")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "List of all the Pets Details"),
            @APIResponse(responseCode = "400",description = "Pet list is empty")

    })
    public Response getAll()
    {
       List<Pet> petModels=petService.getAllMethod();
      //  List<PetModel> petModels=PetModel.listAll();
        return Response.ok(petModels).build();
    }



    //add pet data
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "A pet add")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "Pet Data Added successfully"),
            @APIResponse(responseCode = "400",description = "Some Errors Occured")
    })

    public Response create(Pet petModel)
    {
      return   petService.createPetData(petModel);

    }

    //update pet data

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "update the pet details")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "Pet Data Updated successfully"),
            @APIResponse(responseCode = "404",description = "Pet Id doesn't Exists")

    })

    public Pet updateData(@PathParam("id") Long id, Pet petModel)
    {
        return  petService.updateData(id,petModel);

    }


    //delete a pet
    @DELETE
    @Path("{id}")
    @Operation(summary = "Pet Data Deleted")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",description = "Pet data Deleted successfully"),
            @APIResponse(responseCode = "404",description = "Pet Id doesn't Exists")

    })

    public String deleteById(@PathParam("id") Long id)
    {
       return petService.deletePetData(id);
    }


}
