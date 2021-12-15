package com.example.NetzplanFinal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NetPlanController {



    private List<Knot> knotList = new ArrayList<>();
    private List<KnotInputForm> knotInputFormList = new ArrayList<>();

    @GetMapping("/")
    public String getStartPage() {

        return "home";
    }

    @GetMapping("eingabe")
    public String getKnotInputForm(Model model) {
        model.addAttribute("knotEingabe", new KnotInputForm());
        return "knotInputForm";
    }

    @PostMapping("eingabe")
    public String saveKnotInputForm(@Valid KnotInputForm knotInputForm, BindingResult bindingResult, Model model) {
        model.addAttribute("knotEingabe", new KnotInputForm());
        return "knotInputForm";
    }

    @GetMapping("netzplanTabelle")
    public String getNetplanOutputTable(Model model) {

        return "outputTable";
    }

    public List<Knot> convertKnotInputFormListToKnotList(List<KnotInputForm> knotInputFormList) {

    List<Knot> resultList = new ArrayList<>();

    for (KnotInputForm knotInputForm : knotInputFormList) {
        Knot knot = new Knot(knotInputForm.getOperationNumber(), knotInputForm.getOperationDescription(), knotInputForm.getDurationInMinutes());
        resultList.add(knot);

        if (knotInputForm.getPredecessorOneListIndex() != null) {
            knot.getPredecessor().add(resultList.get(knotInputForm.getPredecessorOneListIndex()));
            resultList.get(knotInputForm.getPredecessorOneListIndex()).getPredecessor().add(knot);
        }
        if (knotInputForm.getPredecessorTwoListIndex() != null) {
            knot.getPredecessor().add(resultList.get(knotInputForm.getPredecessorTwoListIndex()));
            resultList.get(knotInputForm.getPredecessorTwoListIndex()).getPredecessor().add(knot);
        }
        if (knotInputForm.getPredecessorThreeListIndex() != null) {
            knot.getPredecessor().add(resultList.get(knotInputForm.getPredecessorThreeListIndex()));
            resultList.get(knotInputForm.getPredecessorThreeListIndex()).getPredecessor().add(knot);
        }
    }
    return resultList;
    }

    private List<Knot> calculateNetplanResults(List<Knot> knots) {

        return null;
    }
    // TODO: DATENTYP??
    private List<Knot> validateNotTwoEnd (List<Knot> knotList, BindingResult bindingResult) {

        return null;
    }
    //TODO: DATENTYP??
    private KnotInputForm validate(KnotInputForm knotInputForm, BindingResult bindingResult) {

        return null;
    }
}
