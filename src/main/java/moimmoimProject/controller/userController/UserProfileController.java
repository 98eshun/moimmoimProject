package moimmoimProject.controller.userController;

import lombok.RequiredArgsConstructor;
import moimmoimProject.domain.userDomain.UserProfileDto;
import moimmoimProject.service.Assembler.UserProfileAssembler;
import moimmoimProject.service.MoimService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserProfileController {

        private final UserProfileAssembler userProfileAssembler;
        private final MoimService moimService;

        @GetMapping("/userProfile/{userIdNum}")
        public String getUserProfile(@PathVariable Long userIdNum, Model model) {
            UserProfileDto userProfileDto = userProfileAssembler.getUserProfile(userIdNum);
            model.addAttribute("userProfileDto", userProfileDto);
            moimService.checkDeadLine();

            return "/userService/userProfile";
        }
}

