import requests
import tkinter as tk
from tkinter import messagebox

# Configuración inicial
API_KEY = 'C5520B9CAB0F8D01A98B24F24BAAE459'  # Reemplaza con tu API key válida
API_KEY = 'tu_api_key_aqui'  # Reemplaza con tu API key válida
URL = 'https://v3.football.api-sports.io/fixtures'

headers = {
    'x-rapidapi-key': API_KEY,
    'x-rapidapi-host': 'v3.football.api-sports.io'
}

# Función para obtener partidos de una liga específica
def obtener_partidos():
    params = {
        'league': '39',  # Ejemplo: Liga Premier de Inglaterra (puede variar según la API)
        'season': '2024',  # Año de la temporada
        'date': '2024-09-01'  # Fecha específica para pruebas
    }
    
    response = requests.get(URL, headers=headers, params=params)
    
    if response.status_code == 200:
        data = response.json()
        print(data)  # Imprimir la respuesta completa para depuración
        
        enfrentamientos = data.get('response', [])
        
        if enfrentamientos:
            listbox.delete(0, tk.END)  # Limpiar la lista antes de actualizar
            for match in enfrentamientos:
                fixture = match.get('fixture', {})
                teams = match.get('teams', {})
                score = match.get('goals', {})
                
                home_team = teams.get('home', {}).get('name', 'Desconocido')
                away_team = teams.get('away', {}).get('name', 'Desconocido')
                home_score = score.get('home', 0)
                away_score = score.get('away', 0)
                
                partido_info = f"{home_team} {home_score} - {away_score} {away_team}"
                listbox.insert(tk.END, partido_info)
        else:
            listbox.delete(0, tk.END)  # Limpiar la lista antes de mostrar el mensaje
            listbox.insert(tk.END, "No hay partidos disponibles para la consulta.")
    else:
        messagebox.showerror("Error", f"Error al obtener datos: {response.status_code}")

root = tk.Tk()
root.title("Partidos de Fútbol")

listbox = tk.Listbox(root, width=50, height=20)
listbox.pack(pady=20)

btn_actualizar = tk.Button(root, text="Actualizar", command=obtener_partidos)
btn_actualizar.pack()

root.mainloop()