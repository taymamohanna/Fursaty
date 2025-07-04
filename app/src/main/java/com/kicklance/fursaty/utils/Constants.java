package com.kicklance.fursaty.utils;

import com.kicklance.fursaty.models.FAQ;
import com.kicklance.fursaty.models.Job;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Constants {

    public static class Headers {

        public static final String AUTH_BEARER = "Bearer ";
        public static String ACCESS_TOKEN = AUTH_BEARER + "146|NmNVeKL3hmU9GJGrSf3rzFYDlUAGSM3FOIrJc3pr";

    }

    public static class Jobs {
        public static List<Job> getJobs() {
            List<Job> jobs = new ArrayList<>();

            jobs.add(new Job(1, "Android Developer", Stream.of("Java", "Kotlin", "XML").map(s -> new Job.WorkField(0, s)).collect(Collectors.toList()), "2025-12-01",
                    "Build Android apps for modern businesses",
                    new Job.Country(1, "us", "+1", "", "USA"), "2 years", true, "3 days ago", 180, 124,
                    new Job.WorkField(1, "Software Development"), "$3000",
                    new Job.BusinessMan(101, "TechCorp", 50, "Software", "We build scalable mobile solutions.",
                            "https://picsum.photos/seed/techcorp/200/200", "https://picsum.photos/seed/techcorp/600/300", 1)));

            jobs.add(new Job(2, "UI Designer", Stream.of("Figma", "UX", "Prototyping").map(s -> new Job.WorkField(0, s)).collect(Collectors.toList()), "2025-11-15",
                    "Design intuitive mobile interfaces",
                    new Job.Country(2, "ae", "+971", "", "الإمارات"), "1 year", false, "1 week ago", 160, 98,
                    new Job.WorkField(2, "Design"), "$2500",
                    new Job.BusinessMan(102, "Designify", 20, "Creative Agency", "Crafting beautiful user experiences.",
                            "https://picsum.photos/seed/designify/200/200", "https://picsum.photos/seed/designify/600/300", 2)));

            jobs.add(new Job(3, "Backend Engineer", Stream.of("Node.js", "SQL", "Docker").map(s -> new Job.WorkField(0, s)).collect(Collectors.toList()), "2025-10-30",
                    "Develop and maintain scalable APIs",
                    new Job.Country(3, "de", "+49", "", "Germany"), "3 years", true, "2 weeks ago", 150, 2120,
                    new Job.WorkField(3, "Engineering"), "$3200",
                    new Job.BusinessMan(103, "CodeHaus", 35, "Cloud Services", "Experts in backend infrastructure.",
                            "https://picsum.photos/seed/codehaus/200/200", "https://picsum.photos/seed/codehaus/600/300", 3)));

            jobs.add(new Job(4, "QA Tester", Stream.of("JUnit", "Espresso", "Bug Tracking").map(s -> new Job.WorkField(0, s)).collect(Collectors.toList()), "2025-09-20",
                    "Ensure app quality and stability",
                    new Job.Country(4, "in", "+91", "", "India"), "1.5 years", false, "5 days ago", 140, 76,
                    new Job.WorkField(4, "Quality Assurance"), "$2200",
                    new Job.BusinessMan(104, "TestLab", 15, "QA", "We break things so users don’t have to.",
                            "https://picsum.photos/seed/testlab/200/200", "https://picsum.photos/seed/testlab/600/300", 4)));

            jobs.add(new Job(5, "Project Manager", Stream.of("Agile", "Scrum", "Leadership").map(s -> new Job.WorkField(0, s)).collect(Collectors.toList()), "2025-08-10",
                    "Lead cross-functional teams to success",
                    new Job.Country(5, "uk", "+44", "", "UK"), "5 years", true, "1 month ago", 130, 1890,
                    new Job.WorkField(5, "Management"), "$4000",
                    new Job.BusinessMan(105, "SprintFlow", 40, "Consulting", "Delivering agile project success.",
                            "https://picsum.photos/seed/sprintflow/200/200", "https://picsum.photos/seed/sprintflow/600/300", 5)));

            jobs.add(new Job(6, "Data Analyst", Stream.of("Python", "Excel", "Visualization").map(s -> new Job.WorkField(0, s)).collect(Collectors.toList()), "2025-07-01",
                    "Analyze business data and trends",
                    new Job.Country(6, "ca", "+1", "", "Canada"), "2 years", false, "3 weeks ago", 120, 143,
                    new Job.WorkField(6, "Analytics"), "$2800",
                    new Job.BusinessMan(106, "InsightIQ", 25, "Analytics", "Turning data into decisions.",
                            "https://picsum.photos/seed/insightiq/200/200", "https://picsum.photos/seed/insightiq/600/300", 6)));

            jobs.add(new Job(7, "DevOps Engineer", Stream.of("CI/CD", "Kubernetes", "Linux").map(s -> new Job.WorkField(0, s)).collect(Collectors.toList()), "2025-06-15",
                    "Automate deployments and infrastructure",
                    new Job.Country(7, "au", "+61", "", "Australia"), "4 years", true, "2 months ago", 110, 1670,
                    new Job.WorkField(7, "Infrastructure"), "$3500",
                    new Job.BusinessMan(107, "DeployMate", 30, "DevOps", "Infrastructure as code experts.",
                            "https://picsum.photos/seed/deploymate/200/200", "https://picsum.photos/seed/deploymate/600/300", 7)));

            jobs.add(new Job(8, "Content Writer", Stream.of("Markdown", "SEO", "Editing").map(s -> new Job.WorkField(0, s)).collect(Collectors.toList()), "2025-06-01",
                    "Write engaging and optimized content",
                    new Job.Country(8, "eg", "+20", "", "Egypt"), "1 year", false, "1 month ago", 100, 54,
                    new Job.WorkField(8, "Content"), "$1800",
                    new Job.BusinessMan(108, "WriteRight", 10, "Content Services", "Words that work.",
                            "https://picsum.photos/seed/writeright/200/200", "https://picsum.photos/seed/writeright/600/300", 8)));

            jobs.add(new Job(9, "Security Analyst", Stream.of("OWASP", "Pen Testing", "Encryption").map(s -> new Job.WorkField(0, s)).collect(Collectors.toList()), "2025-05-20",
                    "Monitor and secure digital systems",
                    new Job.Country(9, "fr", "+33", "", "France"), "3 years", true, "4 days ago", 90, 3200,
                    new Job.WorkField(9, "Security"), "$3700",
                    new Job.BusinessMan(109, "SecureNet", 60, "Cybersecurity", "Protecting digital assets.",
                            "https://picsum.photos/seed/securenet/200/200", "https://picsum.photos/seed/securenet/600/300", 9)));

            jobs.add(new Job(10, "Flutter Extra", new ArrayList<>(), "2027-06-11", "football football results today...",
                    new Job.Country(10, "ae", "+971", "https://fursaty.kicklance.com/flags/ae.svg", "الإمارات العربية المتحدة"),
                    "0 months", false, "منذ سنة", 719, 12,
                    new Job.WorkField(10, "Sports Media"), "Unspecified",
                    new Job.BusinessMan(110, "KickLance", 5, "Sports Media", "Live football coverage.",
                            "https://picsum.photos/seed/kicklance/200/200", "https://picsum.photos/seed/kicklance/600/300", 10)));

            return jobs;
        }

    }

    public static class FAQs {

        public static List<FAQ> getSampleFAQs() {
            return Arrays.asList(
                    new FAQ(1, "How do I apply for a job?", "Click the 'Apply' button on the job details screen."),
                    new FAQ(2, "Can I edit my profile later?", "Yes, from the Settings menu."),
                    new FAQ(3, "Is my personal data secure?", "We use encryption and secure storage."),
                    new FAQ(4, "How do I change the app language?", "Go to Settings > Language Preference."),
                    new FAQ(5, "What is the job watchlist?", "Save jobs to view or apply later."),
                    new FAQ(6, "How do I contact support?", "Use Help & Feedback in Settings."),
                    new FAQ(7, "Can I apply to multiple jobs?", "Yes, apply to as many as you like."),
                    new FAQ(8, "What happens after I apply?", "Employers may contact you directly."),
                    new FAQ(9, "How do I receive notifications?", "Enable them in Notification Settings."),
                    new FAQ(10, "Is the app free to use?", "Yes, it's completely free for job seekers.")
            );
        }
    }
}
