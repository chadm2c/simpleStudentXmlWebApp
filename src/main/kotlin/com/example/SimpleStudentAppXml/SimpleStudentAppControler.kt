package com.example.SimpleStudentAppXml

import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class XmlController {

    @GetMapping("/")
    fun displayXml(model: Model): String {
        try {
            val xmlContent = ClassPathResource("students.xml").inputStream.bufferedReader().use { it.readText() }
            model.addAttribute("xmlData", xmlContent)
            return "data" // This must match the template filename without .html
        } catch (e: Exception) {
            model.addAttribute("error", "Failed to load XML: ${e.message}")
            return "error" // Simple error page
        }
    }
}