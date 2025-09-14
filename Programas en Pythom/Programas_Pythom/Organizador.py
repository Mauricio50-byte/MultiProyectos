import os
import shutil

extensiones_dic = {
    '.txt': 'documentos',
    '.docx': 'documentos',
    '.pdf': 'documentos',
    '.jpg': 'imagenes',
    '.png': 'imagenes',
    '.exe': 'ejecutables', 
}
predeterminada = 'otros'
ruta_carpeta_organizar = r'C:/Users/ASUS/OneDrive/Escritorio/Programas en Pythom'

archivos = os.listdir(ruta_carpeta_organizar)
for archivo in archivos:
    ruta_archivo = os.path.join(ruta_carpeta_organizar, archivo)
    
    if os.path.isfile(ruta_archivo):
        _, extension = os.path.splitext(archivo)
        nombre_carpeta = extensiones_dic.get(extension.lower(), predeterminada)
        
        carpeta_destino_ruta = os.path.join(ruta_carpeta_organizar, nombre_carpeta)
        
        if not os.path.exists(carpeta_destino_ruta):
            os.makedirs(carpeta_destino_ruta)
            
        shutil.move(ruta_archivo, carpeta_destino_ruta)
        
print("Organización completada correctamente.")