import Link from "next/link";

export default function Home() {
    return (<div>
        <main>
            <Link href={"./base/"}>
                <p>Documentation : <code>Base functionality</code></p>
            </Link>



            <Link href={"./clickables/"}>
                <p>Documentation : <code>Clickable Components</code></p>
            </Link>
        </main>
        <footer>
        </footer>
    </div>)
}
