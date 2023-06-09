

const openModalButtons = document.querySelectorAll("[data-modal-target]");
const closeModalButtons = document.querySelectorAll("[data-close-button]");
const overlay = document.getElementById("noverlay");
console.log("overlay :"+ overlay)
openModalButtons.forEach((button) => {
    button.addEventListener("click", () => {
        const modal = document.querySelector(button.dataset.modalTarget);
        openModal(modal);
    });
});

overlay.addEventListener("click", () => {
    console.log("overlay click :"+ overlay)
    const modals = document.querySelectorAll(".nmodal.active");
    modals.forEach((modal) => {
        closeModal(modal);
    });
    const modals2 = document.querySelectorAll(".nmodal2.active");
    modals2.forEach((modal) => {
        closeModal(modal);
    });
});

closeModalButtons.forEach((button) => {
    button.addEventListener("click", () => {
        const modal = button.closest(".nmodal");
        closeModal(modal);
    });
    button.addEventListener("click", () => {
        const modal = button.closest(".nmodal2");
        closeModal(modal);
    });
});

function openModal(modal) {
    if (modal == null) return;
    modal.classList.add("active");
    overlay.classList.add("active");
}

function closeModal(modal) {
    if (modal == null) return;
    modal.classList.remove("active");
    overlay.classList.remove("active");
}