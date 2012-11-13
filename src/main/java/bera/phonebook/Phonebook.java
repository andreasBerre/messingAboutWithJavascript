package bera.phonebook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/phonebook/")
public class Phonebook {
    private static List<Entry> entries = new ArrayList<Entry>();
    static {
        entries.add(new Entry("Andreas", 98008257));
        entries.add(new Entry("Anna", 95752390));
    }

    @RequestMapping("getEntries")
    @ResponseBody
    public List<Entry> getEntries(){
        return entries;
    }

    @RequestMapping(value="newEntry", method= RequestMethod.POST)
    @ResponseBody
    public String newEntry(@RequestBody Entry newEntry){
        entries.add(newEntry);
        return "OK";
    }
}
