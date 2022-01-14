package fr.greta91.coursSpring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.greta91.coursSpring.model.Product;
import fr.greta91.coursSpring.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public String list(Model model) {
		List<String> list = new ArrayList<String>();
		list.add("Product 1");
		list.add("Product 2");
		list.add("Product 3");
		model.addAttribute("products", list );
		//on renvoie le nom de la vue (fichier jsp)
		return "products/list";
	}
	
	//url : /messages/12, /messages/13...
	@GetMapping("/products/{id}")
	public ModelAndView show(ModelAndView mv, @PathVariable(value = "id") int idProduct) {
		//Spring récupère le param id et le connvertit en entier et l'affecte à la variable idProduit
		mv.setViewName("products/show");//le nom du fichier jsp
		mv.addObject("product", "voici le produit avec l'id : "+ idProduct);//les données
		return mv;
	}
	
	//url : /messages/update?id=12, /messages/update?id=45, ...
	@GetMapping("/products/update")
	public ModelAndView update(ModelAndView mv, @RequestParam(value = "id", required = false, defaultValue = "1") int idProduct) {
		//Spring récupère le param id et le connvertit en entier et l'affecte à la variable idProduit
		Product m = new Product(idProduct,"mon isbn","mon nom","ma designation",10.0,3,"ma categorie");
		mv.setViewName("products/update");//le nom du fichier jsp
		mv.addObject("product", m);//les données
		return mv;
	}
	
	@PostMapping("/products/update")
	public ModelAndView update(ModelAndView mv, @Valid Product product, BindingResult br) {
		System.out.println(product.getNom());
//		boolean valide = message.validate();
		System.out.println(br.getErrorCount());
		System.out.println(br.getAllErrors());
		if(!br.hasErrors()) {
			productService.update();
			mv.setViewName("redirect:/products");//réponse 302
		}
		else {
			mv.setViewName("products/update");
			mv.addObject("product", product);
		}
		return mv;
	}
	
	@GetMapping("/products/add")
	public ModelAndView showAddForm(ModelAndView mv, @ModelAttribute("product") Product product) {
		mv.setViewName("products/add");
		mv.addObject("productBean",new Product("","","",0,0,""));
		return mv;
	}
	
	@PostMapping("/products/add")
	public ModelAndView add(ModelAndView mv, @Valid Product product, BindingResult br) {
		boolean valide = !br.hasErrors();
		if(valide) {
			productService.save();
			mv.setViewName("redirect:/products");//réponse 302
		}
		else {
			List<ObjectError> allErrors = br.getAllErrors();
			for (ObjectError temp : allErrors) {
				System.out.println(temp);
			}
			mv.setViewName("products/add");
			mv.addObject("erreur", "Une erreur s'est produite!");
		}
		return mv;
	}
}
