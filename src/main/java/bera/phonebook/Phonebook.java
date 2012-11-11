package bera.phonebook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/phonebook/")
public class Phonebook {

    @RequestMapping("getEntries")
    @ResponseBody
    public List<Entry> getEntries(){
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry("Andreas", 98008257));
        entries.add(new Entry("Anna", 95752390));
        return entries;
    }
}
