# progettoMarti
Progetto Basi Dati Marti

# DONE:
-model definitivi
-rework controller parte 1: Home/Admin e Prodotti/Vista Prodotti

# DA RIVEDERE?
- modello relazionale tra product-->cartItem-->cart-->order, possibile semplificazione e miglioramento della logica di buisness

# TO DO:
- registrazione clienti
- cart controller
- creazione ordine cliente
- simulazione checkout
- gestione ordini e clienti da parte dell'admin

# Richieste originali:

Un’azienda che commercializza prodotti di elettronica di consumo (è possibile scegliere qualsiasi altra
merce o servizio da vendere) deve commissionare un applicativo web per vendere i suoi prodotti on line
che abbia le seguente caratteristiche:
  1. Possibilità di visualizzare il catalogo prodotti, navigabile per categoria merceologica, marchio,
     ricerca libera, ecc. Possibilità di vedere il singolo prodotto con tutti i dettagli e le caratteristiche
  2. Gestione di prodotti in push (per cui spingere la vendita) con inserimento in una “vetrina in home
     page” o in un area promo
  3. Opzionale (o per progetto in 2 persone): possibilità di visualizzare prodotti graditi al consumatore
     per analogia con lo storico prodotti visualizzati dall’utente,
  4. Opzionale (o per progetto in 2 persone): gestione di una wish list (lista dei desideri)
  5. Possibilità di inserire prodotti nel carrello e di effettuare l’acquisto di più prodotti in diverse
     quantità. Predisporre la gestione dei prezzi, del totale carrello, la gestione della disponibilità di
     magazzino, impedendo di poter acquistare quantità non disponibili
  6. Possibilità di inserire l’indirizzo di consegna, di simulare il pagamento, e di confermare l’ordine
  7. Possibilità di visualizzare lo stato dell’ordine e lo storico degli ordini effettuati
  8. Opzionale (o per progetto in 2 persone): gestione di coupon o buoni sconto in fase di acquisto,
     possibilità di visualizzare il tracking dell’ordine in consegna.
  9. Possibilità degli amministratori di visualizzare gli utenti, verificare il numero degli ordini per utente,
     bloccare eventuali utenti, gestire gli altri utenti amministratori
  10. Possibilità di gestire il catalogo (inserimento, modifica, blocco prodotti), le categorie
     merceologiche, i brand, ecc. Possibilità di gestire la disponibilità di magazzino
  11. Possibilità di visualizzare gli ordini effettuati e di marcarli come consegnati
  12. Opzionale (o per progetto in 2 persone): gestione del tracking dell’ordine, con simulazione di tutti i
     cambi di stato (consegnato al corriere, in viaggio, consegnato al destinatario, ecc.)
  13. Opzionale (o per progetto in 2 persone): gestione dei coupon o buoni sconto

Il sistema prevede che le categorie di utenti sia così rappresentata:

• utenti pubblici che possono solamente eseguire i punti 1 e 2 ed eventualmente registrarsi.

• utenti registrati che possono effettuare i punti fino al punto 8 compreso

• amministratori che possono effettuare i punti dal 9 al 14 compresi 
