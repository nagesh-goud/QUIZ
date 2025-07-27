const questions = [
    {
        question: "What is the capital of France?",
        options: ["Berlin", "Madrid", "Paris", "Rome"],
        answer: "Paris"
    },
    {
        question: "Which programming language is used for web development?",
        options: ["Python", "Java", "JavaScript", "C++"],
        answer: "JavaScript"
    },
    {

        question: "What is the largest planet in our solar system?",
        options: ["Earth", "Jupiter", "Mars", "Venus"],
        answer: "Jupiter"
    }
];

let currentQuestionIndex = 0;
let score = 0;

const questionElement = document.getElementById("question");
const optionsElement = document.getElementById("options");
const nextButton = document.getElementById("next-btn");
const scoreElement = document.getElementById("score");

function loadQuestion() {
    const currentQuestion = questions[currentQuestionIndex];
    questionElement.textContent = currentQuestion.question;
    optionsElement.innerHTML = "";

    currentQuestion.options.forEach(option => {
        const button = document.createElement("button");
        button.classList.add("option");
        button.textContent = option;
        button.addEventListener("click", () => selectAnswer(button, option));
        optionsElement.appendChild(button);
    });
}

function selectAnswer(button, selectedOption) {
    const currentQuestion = questions[currentQuestionIndex];
    if (selectedOption === currentQuestion.answer) {
        button.classList.add("correct");
        score++;
    } else {
        button.classList.add("wrong");
    }
    scoreElement.textContent = `Score: ${score}`;
    setTimeout(() => {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            loadQuestion();
        } else {
            questionElement.textContent = "Quiz Over!";
            optionsElement.innerHTML = `Final Score: ${score}/${questions.length}`;
            nextButton.style.display = "none";
        }
    }, 1000);
}

nextButton.addEventListener("click", () => {
    currentQuestionIndex++;
    if (currentQuestionIndex < questions.length) {
        loadQuestion();
    } else {
        questionElement.textContent = "Quiz Over!";
        optionsElement.innerHTML = `Final Score: ${score}/${questions.length}`;
        nextButton.style.display = "none";
    }
});

// Load first question
loadQuestion();