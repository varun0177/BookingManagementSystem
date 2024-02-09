package controllers;

import Models.Show;
import dtos.CreateShowRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.ShowService;

@RestController
@AllArgsConstructor
public class ShowController {
    private ShowService showService;
    @PostMapping("/show")
    public Show createShow(@RequestBody CreateShowRequest request){

      return  showService.createShow(request);
    }
    @GetMapping("/show/{id}")
    public Show getShow(@PathVariable Long id){
        return  showService.getShow(id);
    }


}
