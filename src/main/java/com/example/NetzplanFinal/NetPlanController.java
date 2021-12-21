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
        model.addAttribute("knotList", knotList);

        return "knotInputForm";
    }

    @PostMapping("eingabe")
    public String saveKnotInputForm(@Valid KnotInputForm knotInputForm, BindingResult bindingResult, Model model) {
        Knot knotToSave = new Knot(knotInputForm.getOperationNumber(), knotInputForm.getOperationDescription(), knotInputForm.getDurationInMinutes());
        if (knotInputForm.getPredecessorOneListIndex() != null) {
            knotToSave.setPredecessor((List<Knot>) knotList.get(knotInputForm.getPredecessorOneListIndex()));
        }
        if (knotInputForm.getPredecessorTwoListIndex() != null) {
            knotToSave.setPredecessor((List<Knot>) knotList.get(knotInputForm.getPredecessorTwoListIndex()));
        }
        if (knotInputForm.getPredecessorThreeListIndex() != null) {
            knotToSave.setPredecessor((List<Knot>) knotList.get(knotInputForm.getPredecessorThreeListIndex()));
        }
        knotList.add(knotToSave);
        model.addAttribute("knotEingabe", new KnotInputForm());
        model.addAttribute("knotList", knotList);
        System.out.println(knotList);
        return "knotInputForm";
    }

    @GetMapping("netzplanTabelle")
    public String getNetplanOutputTable(Model model) {

        return "outputTable";
    }

    public List<Knot> convertKnotInputFormListToKnotList(List<KnotInputForm> knotInputFormList) {
        List<Knot> result = new ArrayList<>();

        for (KnotInputForm inputForm : knotInputFormList) {
            Knot tempKnot = new Knot(inputForm.getOperationNumber(), inputForm.getOperationDescription(), inputForm.getDurationInMinutes());
            result.add(tempKnot);

            if (inputForm.getPredecessorOneListIndex() != null) {
                tempKnot.getPredecessor().add(result.get(inputForm.getPredecessorOneListIndex()));
                result.get(inputForm.getPredecessorOneListIndex()).getSuccessor().add(tempKnot);
            }
            if (inputForm.getPredecessorTwoListIndex() != null) {
                tempKnot.getPredecessor().add(result.get(inputForm.getPredecessorTwoListIndex()));
                result.get(inputForm.getPredecessorTwoListIndex()).getSuccessor().add(tempKnot);
            }
            if (inputForm.getPredecessorThreeListIndex() != null) {
                tempKnot.getPredecessor().add(result.get(inputForm.getPredecessorThreeListIndex()));
                result.get(inputForm.getPredecessorThreeListIndex()).getSuccessor().add(tempKnot);
            }
        }
        return result;
    }

    private void calculateNetplanResults(List<Knot> knots) {


    }

    private void validateNotTwoEnd (List<Knot> knotList, BindingResult bindingResult) {

    }
    //TODO: DATENTYP??
    private KnotInputForm validate(KnotInputForm knotInputForm, BindingResult bindingResult) {

        return null;
    }
}
