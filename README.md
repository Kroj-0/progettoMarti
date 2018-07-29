# progettoMarti
Progetto Basi Dati Marti

# DONE:
- model definitivi
- rework controller e jsp parte 1: Home/Admin e Prodotti/Vista Prodotti     <strong>funzionante</strong>
- rework controller e jsp parte 2: registrazione clienti     <strong>funzionante</strong>
- rework cart REST services completato     <strong>funzionante</strong>
- model, dao, services, controller per gli ordini implementati      <strong>funzionante</strong>
- checkout flow and order confirmation <strong>funzionante</strong>
- aggiunta sulla pagina admin della possibilità di vedere gli utenti, manca ancora la parte di gestione di questi <strong>funzionante</strong>
- DAO, controller e Servizi implementati totalmente per i punti sopra svolti
- gestione utenti fatta, gestione ordini in sviluppo, attendere update a breve

# DA RIVEDERE?
- <s>modello relazionale tra product-->cartItem-->cart-->order, possibile semplificazione e miglioramento della logica</s>
  <strong>cambiato il funzionamento, attendere update, in via di testing, sembra funzionante</strong>
- forse è meglio non mettere le password in chiaro nel db
- mettere un timestamp per gli ordini?

# TO DO:
- <s>registrazione clienti</s>
- <s>cart controller</s>
- manca completamente la gestione delle quantità prodotti, al momento non sono in grado di controllare che non vengano venduti più prodotti di quelli disponibili, ne di cambiare manualmente le quantità dei prodotti nel carrello
- <s>creazione ordine cliente</s>
- <s>simulazione checkout</s>
- gestione ordini e clienti da parte dell'admin <em> parziale </em>
- capacità di navigare il catalogo per marca, tipo, ricerca libera (uso di un plugin third party?)
- ...(vedi richieste originali mancanti)
- rework della grafica/testi

# MIGLIORAMENTI NECESSARI/KNOWN ISSUES:
- sviluppare un modo per cambiare la quantita degli oggetti nel carrello, non solo rimuoverli in blocco, con un refresh automatico del    prezzo totale basato sulla quantita aggiornata a mano dall'utente
- cambiando l'url nella visione del carrello, risulta possibile accedere ai carrelli di altri utenti, poichè il formato dell'url risulta
                                          
                                          http://localhost:8080/customer/cart/1
                                          
 dove l'int rappresenta il cartId univoco per il cliente
 - se modifico un prodotto già esistente come admin, la modifica dell'immagine non funziona sempre (il perchè è un mistero)
 - se come admin metto un prodotto "INACTIVE", lo posso comunque vedere lo stesso nella lista prodotti. Ora questo mi può andare bene per la visione dell'admin (anche se deve essere segnalato in qualche modo), ma l'utente non deve poterli vedere. Tantomeno ordinarli, perchè adesso se li vede li può anche ordinare. All'infinito. (lol)
 - visione del singolo prodotto e inserimento nel carrello, bruttino ma secondario

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
