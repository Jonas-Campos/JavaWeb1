package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.service.TurmaService;

@Controller
@RequestMapping("turma")
public class TurmaController {
	@Autowired
	private TurmaService turmaService;
	@GetMapping("/listarTurmas")
	public ModelAndView listaTodosTurma() {
		ModelAndView mv = new ModelAndView("turma/paginaListaTurmas");
		mv.addObject("turma", turmaService.selectAll());
		return mv;
	}
}
