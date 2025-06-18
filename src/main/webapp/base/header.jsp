<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header>
		<h1>Meu Sistema</h1>
		<div class="header-right">
			<button class="menu-toggle" onclick="toggleSidebar()">☰</button>

			<div class="dropdown">
				<button onclick="toggleDropdown()" class="dropdown-btn">👤
					Usuário ▾</button>
				<div id="dropdown-menu" class="dropdown-menu">

					<a href="#"><i class="fas fa-cog"></i> Configurações</a> <a
						href="#"><i class="fas fa-sign-out-alt"></i> Logout</a>
				</div>
			</div>
		</div>
</header>