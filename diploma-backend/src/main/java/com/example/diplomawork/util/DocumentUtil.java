package com.example.diplomawork.util;

import com.example.diplomawork.model.Reviewer;
import com.example.models.InfoForDocumentTemplateDto;
import com.example.models.UserDto;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class DocumentUtil {

    public static void generateFirstProtocolPdf(InfoForDocumentTemplateDto dto, Reviewer reviewer, String initial) throws IOException, DocumentException {
        String pathtofont = "/fonts/kztimesnewroman.ttf";
        String fontname = DocumentUtil.class.getResource(pathtofont).toString();
        FontFactory.register(fontname);
        BaseFont newTimesRoman = BaseFont.createFont(fontname,
                "Cp1166", BaseFont.EMBEDDED);
        Font font = new Font(newTimesRoman, 12, Font.NORMAL);
        Font boldFont = new Font(newTimesRoman, 12, Font.BOLD);
        Font italic = new Font(newTimesRoman, 12, Font.ITALIC);

        Document protocol1 = new Document();
        PdfWriter writer = PdfWriter.getInstance(protocol1, new FileOutputStream("protocol1.pdf"));

        Paragraph title = new Paragraph("ПРОТОКОЛ № ", font);
        title.setAlignment(Element.ALIGN_CENTER);

        Paragraph subTitle = new Paragraph("Заседания аттестационной комиссии", boldFont);
        subTitle.setAlignment(Element.ALIGN_CENTER);

        Paragraph date = new Paragraph("Дата ____________, время ____________", boldFont);

        Paragraph attended = new Paragraph("Присутствовали:", boldFont);

        String headInfo = "Рахимжанов Н.";
        Paragraph headCommission = new Paragraph("Председатель аттестационной комиссии:" + headInfo, font);
        Paragraph commissionList = new Paragraph("Члены аттестационной комиссии:", font);
        List commissionMembers = new List(List.ORDERED);
        dto.getCommissions().stream().map(userDto -> new ListItem(userDto.getLastName() + " " + userDto.getFirstName(), italic)).forEach(commissionMembers::add);
        commissionMembers.add(new ListItem("Аябекова Д.", italic));

        Chunk studentText = new Chunk("По рассмотрению дипломной работы (проекта) обучающегося ", font);
        Chunk studentInfo = new Chunk(dto.getStudent().getLastName() + " " + dto.getStudent().getFirstName(), italic);
        Paragraph student = new Paragraph();
        student.add(studentText);
        student.add(studentInfo);

        Chunk eduText = new Chunk("по образовательной программе ", font);
        Chunk eduInfo = new Chunk(initial, italic);
        Paragraph eduProgram = new Paragraph();
        eduProgram.add(eduText);
        eduProgram.add(eduInfo);

        Chunk topicText = new Chunk("на тему: ", font);
        Chunk topicInfo = new Chunk(dto.getDefence().getTopic(), italic);
        Paragraph topic = new Paragraph();
        topic.add(topicText);
        topic.add(topicInfo);

        Paragraph language = new Paragraph("Язык дипломной работы (проекта): английский", font);

        Paragraph adviser = new Paragraph("Дипломная работа (проект) обучающегося выполнена под научным руководством:", font);
        Paragraph adviserInfo = new Paragraph(dto.getAdvisor().getLastName() + " " + dto.getAdvisor().getFirstName(), italic);

        Paragraph reviewerInfo = new Paragraph("Рецензент:\n", font);

        Paragraph reviewerItaic = new Paragraph(reviewer.getFullName() + ", " + reviewer.getCareerGrade() + ", " + reviewer.getWorkPlace() + ", " + reviewer.getProfession(), italic);

        String listOfMaterials = "В аттестационную комиссию представлены следующие материалы:\n" +
                "1) \tтекст дипломной работы (проекта) на cтраницах _________;\n" +
                "2) \tотзыв научного руководителя с заключением \"допускается к защите\"\n" +
                "3) \tотзыв рецензента с оценкой _______\n" +
                "4) \tсправка о проверке дипломной работы (проекта) на наличии заимствовании\n";

        List listOfQuestions = new List(List.ORDERED);
        String questions = "Обучающемуся были заданы следующие вопросы: ";
        dto.getQuestions().stream().map(question -> new ListItem(question.getQuestioner().getLastName() + " " + question.getQuestioner().getFirstName() + ": " + question.getDescription(), italic)).forEach(listOfQuestions::add);

        Paragraph predsedatelSign = new Paragraph("                        Председатель ___________________________ Рахимжанов Н.", font);
        predsedatelSign.setAlignment(Element.ALIGN_LEFT);

        Paragraph secretarySign = new Paragraph("                        Секретарь      ___________________________ Аябекова Д.", font);
        secretarySign.setAlignment(Element.ALIGN_LEFT);

        String grade = null;

        if (dto.getGrade() >= 95) {
            grade = "A";
        }
        if (dto.getGrade() >= 90 && dto.getGrade() <= 94) {
            grade = "A-";
        }
        if (dto.getGrade() >= 85 && dto.getGrade() <= 89) {
            grade = "B+";
        }
        if (dto.getGrade() >= 80 && dto.getGrade() <= 84) {
            grade = "B";
        }
        if (dto.getGrade() >= 75 && dto.getGrade() <= 79) {
            grade = "B-";
        }
        if (dto.getGrade() >= 70 && dto.getGrade() <= 74) {
            grade = "C+";
        }
        if (dto.getGrade() >= 65 && dto.getGrade() <= 69) {
            grade = "C";
        }
        if (dto.getGrade() >= 60 && dto.getGrade() <= 64) {
            grade = "C-";
        }

        protocol1.open();
        protocol1.add(title);
        protocol1.add(subTitle);
        protocol1.add(date);
        protocol1.add(attended);
        protocol1.add(headCommission);
        protocol1.add(commissionList);
        protocol1.add(commissionMembers);
        protocol1.add(student);
        protocol1.add(eduProgram);
        protocol1.add(topic);
        protocol1.add(language);
        protocol1.add(adviser);
        protocol1.add(adviserInfo);
        protocol1.add(reviewerInfo);
        protocol1.add(reviewerItaic);
        protocol1.add(new Paragraph(listOfMaterials, font));
        protocol1.add(new Paragraph(questions, font));
        protocol1.add(listOfQuestions);
        protocol1.add(new Paragraph("Общая характеристика ответов обучающегося на заданные ему вопросы", font));
        if (grade.contains("A")) {
            protocol1.add(new Paragraph("- получены исчерпывающие ответы на все вопросы членов комиссии;", font));
            protocol1.add(new Paragraph("- выпускник демонстрирует глубокие базовые знания;", font));
        }
        if (grade.contains("B")) {
            protocol1.add(new Paragraph("- показывает базовые знания, но не в полном объеме;", font));
            protocol1.add(new Paragraph("- обучающийся демонстрирует умение анализировать материал, однако не все выводы достаточно аргументированы;", font));
        }
        if (grade.contains("C")) {
            protocol1.add(new Paragraph("- отсутствует ответ на один из вопросов;", font));
            protocol1.add(new Paragraph("- нарушается последовательность изложения материала и т.д.;", font));
        }

        Chunk gradeInfo = new Chunk(dto.getGrade().toString() + " (" + grade + ")", italic);
        protocol1.add(new Paragraph("Признать, что обучающийся выполнил и защитил дипломную работу (проект) с оценкой: " + gradeInfo, font));
        protocol1.add(new Paragraph("Особые мнения членов комиссии", font));
        protocol1.add(new Paragraph("_______________________________________________________________________________________ \n\n\n", font));
        protocol1.add(predsedatelSign);

        for (UserDto commission : dto.getCommissions()) {
            Paragraph commissionInfo = new Paragraph("                                                ___________________________ " + commission.getLastName() + " " + commission.getFirstName(), font);
            commissionInfo.setAlignment(Element.ALIGN_LEFT);
            protocol1.add(commissionInfo);
        }

        protocol1.add(secretarySign);
        protocol1.close();
        writer.close();
    }

    public static void generateSecondProtocolPdf(InfoForDocumentTemplateDto dto, Reviewer reviewer, String initial) throws IOException, DocumentException {
        String pathtofont = "/fonts/kztimesnewroman.ttf";
        String fontname = DocumentUtil.class.getResource(pathtofont).toString();
        FontFactory.register(fontname);
        BaseFont newTimesRoman = BaseFont.createFont(fontname,
                "Cp1166", BaseFont.EMBEDDED);
        Font font = new Font(newTimesRoman, 12, Font.NORMAL);
        Font boldFont = new Font(newTimesRoman, 12, Font.BOLD);
        Font italic = new Font(newTimesRoman, 12, Font.ITALIC);

        Document protocol2 = new Document();
        PdfWriter writer2 = PdfWriter.getInstance(protocol2, new FileOutputStream("protocol2.pdf"));

        Paragraph title = new Paragraph("ПРОТОКОЛ № ", font);
        title.setAlignment(Element.ALIGN_CENTER);

        Paragraph subTitle = new Paragraph("Заседания аттестационной комиссии", boldFont);
        subTitle.setAlignment(Element.ALIGN_CENTER);

        Paragraph date = new Paragraph("Дата ____________", boldFont);

        Paragraph header = new Paragraph("о присуждении степени бакалавра обучающемуся, защитившему дипломную работу (проект).\n", font);

        Paragraph attended = new Paragraph("Присутствовали:", boldFont);

        String headInfo = "Рахимжанов Н.";

        Paragraph headCommission = new Paragraph("Председатель аттестационной комиссии:" + " " + headInfo, font);

        Paragraph commissionList = new Paragraph("Члены аттестационной комиссии: ", font);
        List commissionMembers = new List(List.ORDERED);
        dto.getCommissions().stream().map(userDto -> new ListItem(userDto.getLastName() + " " + userDto.getFirstName(), italic)).forEach(commissionMembers::add);
        commissionMembers.add(new ListItem("Аябекова Д.", italic));

        Chunk studentText1 = new Chunk("Обучающийся ", font);
        Chunk studentInfo = new Chunk(dto.getStudent().getLastName() + " " + dto.getStudent().getFirstName(), italic);
        Paragraph student = new Paragraph();
        student.add(studentText1);
        student.add(studentInfo);

        Chunk initialText = new Chunk("по образовательной программе ", font);
        Chunk initialItalic = new Chunk(initial, italic);
        Paragraph initialInfo = new Paragraph();
        initialInfo.add(initialText);
        initialInfo.add(initialItalic);

        Chunk topicText = new Chunk("защитил дипломную работу (проект): ", font);
        Chunk topicItalic = new Chunk(dto.getDefence().getTopic() + "\n", italic);
        Paragraph topicWithGrade = new Paragraph();
        topicWithGrade.add(topicText);
        topicWithGrade.add(topicItalic);

        String grade = null;

        if (dto.getGrade() >= 95) {
            grade = "A";
        }
        if (dto.getGrade() >= 90 && dto.getGrade() <= 94) {
            grade = "A-";
        }
        if (dto.getGrade() >= 85 && dto.getGrade() <= 89) {
            grade = "B+";
        }
        if (dto.getGrade() >= 80 && dto.getGrade() <= 84) {
            grade = "B";
        }
        if (dto.getGrade() >= 75 && dto.getGrade() <= 79) {
            grade = "B-";
        }
        if (dto.getGrade() >= 70 && dto.getGrade() <= 74) {
            grade = "C+";
        }
        if (dto.getGrade() >= 65 && dto.getGrade() <= 69) {
            grade = "C";
        }
        if (dto.getGrade() >= 60 && dto.getGrade() <= 64) {
            grade = "C-";
        }

        Chunk gradeText = new Chunk("с оценкой: ", font);
        Chunk gradeItalic = new Chunk(dto.getGrade().toString() + " (" + grade + ")" + "\n\n", italic);
        Paragraph gradeInfo = new Paragraph();
        gradeInfo.add(gradeText);
        gradeInfo.add(gradeItalic);

        Chunk studentText2 = new Chunk("Присудить обучающемуся ", font);
        Chunk studentShort = new Chunk(dto.getStudent().getLastName() + " " + dto.getStudent().getFirstName().charAt(0) + ".", italic);
        Paragraph examPass = new Paragraph();
        examPass.add(studentText2);
        examPass.add(studentShort);


        Chunk ictText1 = new Chunk("Степень бакалавр ", font);
        Chunk ictInfo = new Chunk("Информационно-Коммуникационные Технологии", italic);
        Chunk ictText2 = new Chunk(" по образовательной программе ", font);
        Paragraph degree = new Paragraph();
        degree.add(ictText1);
        degree.add(ictInfo);
        degree.add(ictText2);
        degree.add(initialItalic);

        String isHonor = "без отличия";

        if (dto.getStudent().getIsHonor() && dto.getGrade() >= 90) {
            isHonor = "с отличием";
        }

        Chunk diplomaInfoText = new Chunk("Выдать диплом о высшем образовании ", font);
        Chunk honor = new Chunk(isHonor + "\n\n\n", italic);
        Paragraph diplomaInfo = new Paragraph();
        diplomaInfo.add(diplomaInfoText);
        diplomaInfo.add(honor);

        Paragraph predsedatelSign = new Paragraph("                        Председатель ___________________________ Рахимжанов Н.", font);
        predsedatelSign.setAlignment(Element.ALIGN_LEFT);

        Paragraph secretarySign = new Paragraph("                        Секретарь      ___________________________ Аябекова Д.", font);
        secretarySign.setAlignment(Element.ALIGN_LEFT);

        protocol2.open();
        protocol2.add(title);
        protocol2.add(subTitle);
        protocol2.add(date);
        protocol2.add(header);
        protocol2.add(attended);
        protocol2.add(headCommission);
        protocol2.add(commissionList);
        protocol2.add(commissionMembers);
        protocol2.add(student);
        protocol2.add(initialInfo);
        protocol2.add(topicWithGrade);
        protocol2.add(gradeInfo);
        protocol2.add(examPass);
        protocol2.add(degree);
        protocol2.add(new Paragraph("Особые мнения членов комиссии", font));
        protocol2.add(new Paragraph("_______________________________________________________________________________________ \n", font));
        protocol2.add(diplomaInfo);
        protocol2.add(predsedatelSign);

        for (UserDto commission : dto.getCommissions()) {
            Paragraph commissionInfo = new Paragraph("                                                ___________________________ " + commission.getLastName() + " " + commission.getFirstName(), font);
            commissionInfo.setAlignment(Element.ALIGN_LEFT);
            protocol2.add(commissionInfo);
        }
        protocol2.add(secretarySign);
        protocol2.close();
        writer2.close();
    }
}
