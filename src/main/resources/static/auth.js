const credentials = {
  user: {
    username: "user",
    password: "user123",
    displayName: "User",
    actions: [
      {
        icon: "📝",
        title: "Report lost item",
        description: "Submit details about items that were misplaced so matching can begin."
      },
      {
        icon: "📦",
        title: "Report found item",
        description: "Register recovered items with location, date, and identifying information."
      },
      {
        icon: "🔎",
        title: "Search items",
        description: "Browse and filter reported items to look for potential matches."
      },
      {
        icon: "🙋",
        title: "Claim item",
        description: "Start a claim request when you find an item that belongs to you."
      }
    ]
  },
  admin: {
    username: "admin",
    password: "admin123",
    displayName: "Admin",
    actions: [
      {
        icon: "✅",
        title: "Verify claims",
        description: "Review supporting details and validate ownership evidence."
      },
      {
        icon: "⚖️",
        title: "Approve / reject claims",
        description: "Finalize claim decisions and update claim status for users."
      },
      {
        icon: "🗂️",
        title: "Manage items",
        description: "Maintain the item catalog and keep listing data current."
      }
    ]
  }
};

function storeSession(roleKey) {
  const account = credentials[roleKey];
  sessionStorage.setItem(
    "lostfoundSession",
    JSON.stringify({
      role: roleKey,
      displayName: account.displayName
    })
  );
}

function getSession() {
  const raw = sessionStorage.getItem("lostfoundSession");
  return raw ? JSON.parse(raw) : null;
}

function clearSession() {
  sessionStorage.removeItem("lostfoundSession");
}

function initializeLoginPage() {
  const form = document.getElementById("loginForm");
  if (!form) {
    return;
  }

  const roleInput = document.getElementById("role");
  const usernameInput = document.getElementById("username");
  const passwordInput = document.getElementById("password");
  const status = document.getElementById("loginStatus");

  form.addEventListener("submit", (event) => {
    event.preventDefault();

    const role = roleInput.value;
    const account = credentials[role];

    if (!account) {
      status.textContent = "Select a valid role to continue.";
      status.className = "status-message error";
      return;
    }

    const username = usernameInput.value.trim();
    const password = passwordInput.value.trim();

    if (username !== account.username || password !== account.password) {
      status.textContent = "Invalid login details for the selected role.";
      status.className = "status-message error";
      return;
    }

    storeSession(role);
    status.textContent = "Login successful. Redirecting to dashboard...";
    status.className = "status-message success";

    window.location.href = "/dashboard";
  });
}

function initializeDashboardPage() {
  const dashboardRoot = document.getElementById("dashboardRoot");
  if (!dashboardRoot) {
    return;
  }

  const session = getSession();
  if (!session || !credentials[session.role]) {
    window.location.href = "index.html";
    return;
  }

  const account = credentials[session.role];
  document.getElementById("roleTitle").textContent = account.displayName;
  document.getElementById("roleChip").textContent = account.displayName;
  document.getElementById("dashboardSubtitle").textContent =
    account.displayName === "Admin"
      ? "Administrative tools for claim review and item governance."
      : "Quick access to reporting, searching, and claim workflows.";

  const cardGrid = document.getElementById("actionGrid");
  cardGrid.innerHTML = "";

  account.actions.forEach((action) => {
    const card = document.createElement("article");
    card.className = "action-card";
    card.innerHTML = `
      <div class="action-icon">${action.icon}</div>
      <h3>${action.title}</h3>
      <p>${action.description}</p>
    `;
    cardGrid.appendChild(card);
  });

  const logoutButton = document.getElementById("logoutButton");
  logoutButton.addEventListener("click", () => {
    clearSession();
    window.location.href = "index.html";
  });
}

document.addEventListener("DOMContentLoaded", () => {
  initializeLoginPage();
  initializeDashboardPage();
});
