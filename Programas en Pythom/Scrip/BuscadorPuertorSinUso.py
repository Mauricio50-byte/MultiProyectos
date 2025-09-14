import socket

def find_available_port(start_port, end_port):
    for port in range(start_port, end_port + 1):
        try:
            with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
                s.bind(('127.0.0.1', port))
            return port
        except OSError:
            pass
    return None

start_port = 5000  # Puerto inicial
end_port = 6000    # Puerto final
available_port = find_available_port(start_port, end_port)

if available_port:
    print(f"El puerto disponible encontrado: {available_port}")
else:
    print("No se encontró ningún puerto disponible en el rango especificado.")