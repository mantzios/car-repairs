package com.teamnine.carrepairs.controller;

import com.teamnine.carrepairs.converter.RepairConverter;
import com.teamnine.carrepairs.domain.Repair;
import com.teamnine.carrepairs.model.CreateRepairForm;
import com.teamnine.carrepairs.service.RepairService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
@Controller
public class EditRepairController {

        private  final static org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class);
        private static final String FORM = "editRepairForm";

        @Autowired
        private RepairService repairService;

        @RequestMapping(value = "/admin/edit/repair", method = RequestMethod.GET)
        public String register(Model model, @RequestParam(name = "id", required = true) long id) {
            Repair repair = repairService.findById(id);


            model.addAttribute(FORM, new CreateRepairForm());
            model.addAttribute("repair", repair);
            return "editRepair";

        }



      /*  @RequestMapping(value = "/admin/repairs", method = RequestMethod.POST)
        public String register(@Valid @ModelAttribute(FORM)
                                       CreateRepairForm createRepairForm,
                               BindingResult bindingResult, HttpSession session,
                               RedirectAttributes redirectAttributes) {
            long id;

            if (bindingResult.hasErrors()) {
                //have some error handling here, perhaps add extra error messages to the model
                //for now we're going to return a view ( register) but normally we would redirect to the
                //get method after adding the binding result and the form to the redirect attributes.
                logger.error(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
                return "repairs";
            }

            try {
                Repair repair = RepairConverter.buildRepairObject(createRepairForm);
                id = repairService.save(repair);

            } catch (Exception exception) {
                //if an error occurs show it to the user
                redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
                logger.error("User registration failed: " + exception);
                return "redirect:/admin/repairs";
            }




            redirectAttributes.addFlashAttribute("message", "Repair successfully added with id: "+id);
            return "redirect:/admin/repairs";




        }*/
    }


