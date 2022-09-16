package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Professor;
import br.com.senac.service.ProfessorService;

@Controller
@RequestMapping("professor")
public class ProfessorController {
	@Autowired
	private ProfessorService professorService;
	@GetMapping("/listarProfessores")
	public ModelAndView listaTodosProfessores() {
		ModelAndView mv = new ModelAndView("professor/paginaListaProfessores");
		mv.addObject("professor", professorService.selectAll());
		return mv;
	}
	
	@GetMapping("/cadastrarProfessores")
	public ModelAndView cadastrarProfessores() {
		ModelAndView mv = new ModelAndView ("professor/cadastrarProfessores");
		mv.addObject("Professor",new Professor());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarProfessores(Professor Professor) {
		professorService.insert(Professor);
		return listaTodosProfessores();
	}
}
