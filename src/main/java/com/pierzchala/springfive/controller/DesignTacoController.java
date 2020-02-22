package com.pierzchala.springfive.controller;

import com.pierzchala.springfive.tacos.Ingredient;
import com.pierzchala.springfive.tacos.Taco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/design")
public class DesignTacoController {

    private Logger LOGGER = LoggerFactory.getLogger("Logger");

    private List<Ingredient> getIngredients() {
        return Arrays.asList(
                new Ingredient("FLTO", "pszenna", Ingredient.Type.WRAP),
                new Ingredient("COTO", "kukurydziana", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "mielona wołowina ", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "kawałki mięsa", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "pomidory pokrojone w kostkę", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "sałata", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "pikantny sos pomidorowy", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "śmietana", Ingredient.Type.SAUCE)
        );
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = getIngredients();
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {

            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));

        }
        model.addAttribute("taco", new Taco());
        return "design";
    }


    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {

        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());

    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors, Model model) {
        if (errors.hasErrors()) {
            // musi być powtorzone, jak w get !!! inaczej checkboxy znikają przy błędach walidacji
            List<Ingredient> ingredients = getIngredients();
            Ingredient.Type[] types = Ingredient.Type.values();
            for (Ingredient.Type type : types) {

                model.addAttribute(type.toString().toLowerCase(),
                        filterByType(ingredients, type));

            }
            return "design";
        }
// Zapisanie projektu przygotowanego taco…
// Tym się zajmiesz w rozdziale 3.
        LOGGER.info("Przetwarzanie projektu taco: ");


        return "redirect:/orders/current";
    }

    @GetMapping("/test")
    public String test(Model model) {

        List<Ingredient> ingredients = getIngredients();
        model.addAttribute("ingredient", ingredients);
        model.addAttribute("message", "This is test of message");

        return "test";
    }
}
